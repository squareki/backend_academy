import Reply
import IO

import Control.Monad
import System.Environment

main :: IO ()
main = do
    args <- getArgs
    unless (args /= [] && length args == 1) (error "Bad call: specify only one argument -- comments directory")
    putStrLn $ head args

    comments <- getReplyContents (head args)
    case comments of
        Left errStr -> error errStr
        Right comments -> do
        replyChain <- getReplyChainJSON
        case replyChain of
            Left errStr -> error errStr
            Right replyChain -> printRepliesTree (addContents replyChain comments)
