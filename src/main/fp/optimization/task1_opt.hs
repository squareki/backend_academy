import Control.Arrow (Arrow (first))
import Data.Char (chr)

main :: IO ()
main = do
  let foo = curry ( chr . uncurry (-) . first ((`mod` 1021)) );
  let bar = fibs (length numbers)
  let answer = zipWith foo bar numbers;
  putStrLn answer  

fibs' :: [Int]
fibs' = map fst $ iterate (\(x, y) -> (y, x + y)) (233, 666)

fibs :: Int -> [Int]
fibs n = take n fibs'

numbers = [153, 586, 819, 461, 354, 843, 263, 215, 564, 884, 548, 511, 139, 814, -16, 853, -73, 886, 921, 870, 926, 886, 784, 763, 589, 364, 20, 502, 650, 237, -49, 288, 373, 774, 203, 73, 378, 549, 4, 657, 777, 592, 396, 89, 543, 696, 322, 144, 562, 761, 304, 144, 546, 736, 307, 32, 436, 572, -4, 618, 715, 462, 245, 762, -2, 856, 965, 833, 734]
