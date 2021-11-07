import Control.Arrow (Arrow (first))
import Data.Char (chr)

main :: IO ()
main =
  putStrLn answer
  where
    answer = zipWith foo bar numbers
    foo = curry $ chr . uncurry (-) . first ((`mod` 1021) . e)
    bar = c1 : c2 : zipWith f bar (tail bar)

f :: Eq a => [a] -> [a] -> [a]
f x y
  | d1 `c` a x y = sb x y
  | a x y `c` d2 = a x y
  | otherwise = f x $ m x y

z :: [a]
z = []

s :: [()] -> [()]
s x = () : x

a :: Eq a => [a] -> [a] -> [a]
a x y | x == z = y
a (x : xs) y = a xs (x : y)

sb :: Eq a => [b] -> [a] -> [b]
sb x y | y == z = x
sb (_ : xs) (_ : ys) = sb xs ys

m :: (Eq a, Eq b) => [b] -> [a] -> [b]
m x y | y == z = z
m x (y : ys) = a x $ m x ys

c :: (Eq a, Eq b) => [b] -> [a] -> Bool
c _ y | y == z = True
c x _ | x == z = False
c (_ : xs) (y : ys) = c xs ys

e :: (Eq a, Num p) => [a] -> p
e x | x == z = 0
e (_ : xs) = (1 +) $ e xs

numbers = [153, 586, 819, 461, 354, 843, 263, 215, 564, 884, 548, 511, 139, 814, -16, 853, -73, 886, 921, 870, 926, 886, 784, 763, 589, 364, 20, 502, 650, 237, -49, 288, 373, 774, 203, 73, 378, 549, 4, 657, 777, 592, 396, 89, 543, 696, 322, 144, 562, 761, 304, 144, 546, 736, 307, 32, 436, 572, -4, 618, 715, 462, 245, 762, -2, 856, 965, 833, 734]

c1 = s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s z

c2 = s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s z

d1 = s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s z

d2 = s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s $ s z
