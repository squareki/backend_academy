{-# LANGUAGE OverloadedStrings #-}

module IO where
import Reply

import Control.Monad

import Data.Aeson
import Data.Maybe (isNothing)
import Data.ByteString.Lazy.Char8 (pack, unpack)

import System.Directory
import System.FilePath.Posix

-- read all files given by [FilePath] and put their contents
-- into [String]
readFiles :: [FilePath] -> IO [String]
readFiles = traverse readFile

-- get all suitable files in given dir
dirFiles :: String -> FilePath -> IO [FilePath]
dirFiles ext dir = do
  files <- listDirectory dir
  return $ map (\f -> dir ++ "/" ++ f) $ reverse $ filter (\f -> takeExtension f == ext) files

-- read all matching files in given dir
getReplyContents :: String -> IO ((Either String [String]))
getReplyContents dir = do
    dirExists <- doesDirectoryExist dir
    if not dirExists
    then return $ Left "Could not find requested directory"
    else do
    putStrLn "Found requested directory"

    filesFiltered <- dirFiles ".txt" dir
    if (length filesFiltered == 0)
    then return $ Left "No suitable files found in requested directory"
    else do
    putStrLn $ "Found files: " ++ show filesFiltered

    comments <- readFiles filesFiltered

    print $ comments
    return $ Right comments


-- read Reply JSON from stdin
getReplyChainJSON :: IO (Either String [Reply])
getReplyChainJSON = do
    contents <- getContents
    let decoded = decode (pack contents)
    case decoded of
        Just r -> return $ Right [r]
        Nothing -> return $ Left "Bad input: could not decode from JSON"
