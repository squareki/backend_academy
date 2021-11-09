{-# LANGUAGE OverloadedStrings #-}
{-# LANGUAGE DeriveGeneric   #-}

module Reply where
import Data.Aeson
import Data.Aeson.Encode.Pretty
import Data.ByteString.Lazy.Char8 (ByteString, pack, unpack)
import GHC.Generics

data Reply = Reply
             { id :: Int
             , content :: Maybe String
             , replies :: [Reply]
             } deriving (Show, Generic)

instance FromJSON Reply where
    parseJSON = genericParseJSON defaultOptions
        { omitNothingFields = True }

instance ToJSON Reply where
    toJSON = genericToJSON defaultOptions
        { omitNothingFields = True }


-- print replies data
printReplies :: [Reply] -> IO ()
printReplies [] = return ()
printReplies ((Reply r c rs):xs) = do
    print r
    print c
    printReplies rs
    printReplies xs

-- print replies with comments that need to be inserted
printRepliesCont :: [Reply] -> [String] -> IO ()
printRepliesCont [] _ = return ()
printRepliesCont ((Reply r com rs):xs) (c:cs) = do
    print r
    print $ (show com) ++ " " ++ (show c) ++ "\n"
    printRepliesCont rs cs
    printRepliesCont xs cs

-- encode replies with config to preserve key order
encodeReplyTree :: [Reply] -> ByteString
encodeReplyTree r = encodePretty' conf r
                    where conf = defConfig {confCompare = keyOrder ["id", "content", "replies"]}

-- pretty-print replies tree
printRepliesTree :: [Reply] -> IO ()
printRepliesTree r = putStrLn $ unpack $ encodeReplyTree r

-- insert comments
addContents :: [Reply] -> [String] -> [Reply]
addContents [] _ = []
addContents ((Reply r _ rs):xs) (c:cs) = do
    Reply r (Just c) (addContents rs cs) : addContents xs cs

-- get rid of Maybe wrapper
replyFromMaybe :: Maybe Reply -> [Reply]
replyFromMaybe Nothing = []
replyFromMaybe (Just r) = [r]
