{-# LANGUAGE OverloadedStrings #-}

import Prelude hiding (id)
import Data.Aeson
import Data.ByteString.Lazy.Char8 hiding (hGetContents, head)
import Reply
import Test.HUnit
import System.IO

areEqualReplies :: [Reply] -> [Reply] -> Bool
areEqualReplies [] [] = True
areEqualReplies _ [] = False
areEqualReplies [] _ = False
areEqualReplies ((Reply aid acontent ar):xs) ((Reply bid bcontent br):ys) =
    (aid == bid) && (acontent == bcontent) && (areEqualReplies ar br) && (areEqualReplies xs ys)

areEqualReplies' :: Maybe Reply -> Maybe Reply -> Bool
areEqualReplies' (Just (Reply aid acontent ar)) (Just (Reply bid bcontent br)) = do
    (aid == bid) && (acontent == bcontent) && (areEqualReplies ar br)

main :: IO ()
main = do
    input <- openFile "input.txt" ReadMode
    chain <- hGetContents input

    let comments = ["lorem ipsum", "dolor sit amet", "consectetur adipiscing elit", "sed do eiusmod", "tempor incididunt ut labore"]

    -- expected
    let decodeEmpty = Just (Reply {id = 1, content = Nothing, replies = 
    [Reply {id = 2, content = Nothing, replies = []},Reply {id = 3, content = Nothing, replies =
    [Reply {id = 4, content = Nothing, replies = []},Reply {id = 5, content = Nothing, replies = []}]}]
    })

    let zipped = (Reply {id = 1, content = Just "lorem ipsum", replies = 
    [Reply {id = 2, content = Just "dolor sit amet", replies = []},Reply {id = 3, content = Just "consectetur adipiscing elit", replies =
    [Reply {id = 4, content = Just "sed do eiusmod", replies = []},Reply {id = 5, content = Just "tempor incididunt ut labore", replies = []}]}]
    })

    let actual = ((decode (pack chain)) :: Maybe Reply )
    let testDecode = TestCase $ assertBool "Decode (empty)" (areEqualReplies' (decodeEmpty) (actual) )
    let testZip = TestCase $ assertBool "AddContents" $ areEqualReplies ([zipped]) (addContents (replyFromMaybe actual) comments)
    let testEncode = TestCase $ assertBool "Encode" $ areEqualReplies ([zipped]) $ replyFromMaybe $ decode $ encode zipped
    let testlist = TestList  [ TestLabel "testDecode" testDecode,
                               TestLabel "testZip" testZip,
                               TestLabel "testEncode" testEncode ]    

    runTestTT testlist
    return ()
