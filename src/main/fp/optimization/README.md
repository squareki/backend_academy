# Оптимизация

## Условие задачи
Дан исходный код программы на языке Haskell. Необходимо оптимизировать код так, чтобы программа завершилась за разумное время.

## Код
```haskell
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
```

## Анализ кода

В данном разделе будет произведён последовательный анализ кода для получения оптимизированной программы.

---
### **Функции $`s`$ и $`z`$**

```haskell
z :: [a]
z = []

s :: [()] -> [()]
s x = () : x
```

Нетрудно заметить, что функция **$`z`$** возвращает пустой список, а функция **$`s(x)`$** присоединяет пустой кортеж к данному списку **$`x`$**. Тогда очевидно, что определённые в конце кода переменные можно записать коротко с использованием встроенной функции $`replicate`$, а вызовы функции **$`z`$** заменить на пустой список.

```haskell
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

a :: Eq a => [a] -> [a] -> [a]
a x y | x == [] = y
a (x : xs) y = a xs (x : y)

sb :: Eq a => [b] -> [a] -> [b]
sb x y | y == [] = x
sb (_ : xs) (_ : ys) = sb xs ys

m :: (Eq a, Eq b) => [b] -> [a] -> [b]
m x y | y == [] = []
m x (y : ys) = a x $ m x ys

c :: (Eq a, Eq b) => [b] -> [a] -> Bool
c _ y | y == [] = True
c x _ | x == [] = False
c (_ : xs) (y : ys) = c xs ys

e :: (Eq a, Num p) => [a] -> p
e x | x == [] = 0
e (_ : xs) = (1 +) $ e xs

numbers = [153, 586, 819, 461, 354, 843, 263, 215, 564, 884, 548, 511, 139, 814, -16, 853, -73, 886, 921, 870, 926, 886, 784, 763, 589, 364, 20, 502, 650, 237, -49, 288, 373, 774, 203, 73, 378, 549, 4, 657, 777, 592, 396, 89, 543, 696, 322, 144, 562, 761, 304, 144, 546, 736, 307, 32, 436, 572, -4, 618, 715, 462, 245, 762, -2, 856, 965, 833, 734]

c1 = replicate 233 ()
c2 = replicate 666 ()
d1 = replicate 512 ()
d2 = replicate 800 ()
```

### **Функция $`e`$**

```haskell
e :: (Eq a, Num p) => [a] -> p
e x | x == [] = 0
e (_ : xs) = (1 +) $ e xs
```

Функция **$`e(x:xs)`$** возвращает:
* $`0`$, если данный список $`x`$ пустой,
* $`1 + e(xs)`$ иначе.

Очевидно, данная функция определяет размер списка, данного в качестве аргумента. Тогда её можно заменить на встроенную функцию `length`.
```haskell
import Control.Arrow (Arrow (first))
import Data.Char (chr)

main :: IO ()
main =
  putStrLn answer
  where
    answer = zipWith foo bar numbers
    foo = curry $ chr . uncurry (-) . first ((`mod` 1021) . length)
    bar = c1 : c2 : zipWith f bar (tail bar)

f :: Eq a => [a] -> [a] -> [a]
f x y
  | d1 `c` a x y = sb x y
  | a x y `c` d2 = a x y
  | otherwise = f x $ m x y

a :: Eq a => [a] -> [a] -> [a]
a x y | x == [] = y
a (x : xs) y = a xs (x : y)

sb :: Eq a => [b] -> [a] -> [b]
sb x y | y == [] = x
sb (_ : xs) (_ : ys) = sb xs ys

m :: (Eq a, Eq b) => [b] -> [a] -> [b]
m x y | y == [] = []
m x (y : ys) = a x $ m x ys

c :: (Eq a, Eq b) => [b] -> [a] -> Bool
c _ y | y == [] = True
c x _ | x == [] = False
c (_ : xs) (y : ys) = c xs ys

numbers = [153, 586, 819, 461, 354, 843, 263, 215, 564, 884, 548, 511, 139, 814, -16, 853, -73, 886, 921, 870, 926, 886, 784, 763, 589, 364, 20, 502, 650, 237, -49, 288, 373, 774, 203, 73, 378, 549, 4, 657, 777, 592, 396, 89, 543, 696, 322, 144, 562, 761, 304, 144, 546, 736, 307, 32, 436, 572, -4, 618, 715, 462, 245, 762, -2, 856, 965, 833, 734]

c1 = replicate 233 ()
c2 = replicate 666 ()
d1 = replicate 512 ()
d2 = replicate 800 ()
```
Следует обратить внимание на строку, где использовалась данная функция:
```haskell
foo = curry $ chr . uncurry (-) . first ((`mod` 1021) . length)
```
Можно заметить, что берётся длина списка, над которой далее произодится операция взятия остатка от деления на 1021. Эта строка уже может сигнализировать о том, что, возможно, получаемые размеры можно вычислить заранее.

### **Функция $`с`$**

```haskell
c :: (Eq a, Eq b) => [b] -> [a] -> Bool
c _ y | y == [] = True
c x _ | x == [] = False
c (_ : xs) (y : ys) = c xs ys
```

Функция **$`с[(x:xs),(y:ys)]`$** возвращает:
* $`True`$, если данный список $`y`$ пустой,
* $`False`$, если данный список $`x`$ пустой
* $`c(xs, ys)`$ иначе.

Из последнего пункта несложно заметить, что функция сокращает входные массивы, удаляя головы списков каждый раз, когда их длины не равны нулю, то есть пока один из массивов не станет пустым.

Допустим, на вход подаются массивы $`a`$ и $`b`$ длин $`n`$ и $`m`$ соответственно, $`m_i`$ - массив $`m`$ без первых $`i`$ элементов. Тогда:
* если $`n > m`$: функция достигает момента, когда $`a_i`$ ещё содержит элементы, а $`b_i`$ пуст. Возвращается $`True`$.
* если $`n < m`$: функция достигает момента, когда $`a_i`$ пуст, а $`b_i`$ ещё содержит элементы. Возвращается $`False`$.
* если $`n = m`$: функция достигает момента, когда оба списка $`a_i`$ и  $`b_i`$ пусты. Так как выполняется условие пустоты  $`b_i`$, возвращается $`True`$.

Нетрудно заметить, что функция возвращает $`True`$, если $`n \geq m`$. Тогда функцию можно перезаписать следующим образом:
```haskell
c :: (Eq a, Eq b) => [b] -> [a] -> Bool
c x y = (length x) >= (length y)
```
Следует проанализировать где используется данная фунция:
```haskell
f :: Eq a => [a] -> [a] -> [a]
f x y
  | d1 `c` a x y = sb x y
  | a x y `c` d2 = a x y
  | otherwise = f x $ m x y
```
Так как у массивов $`d_1`$ и $`d_2`$ размеры постоянные, функцию $`c`$ можно заменить здесь с использованием вышеуказанной записи:
```haskell
f :: Eq a => [a] -> [a] -> [a]
f x y
  | 512 >= length (a x y) = sb x y
  | length (a x y) >= 800 = a x y
  | otherwise = f x $ m x y
```
Так как $`d_1`$ и $`d_2`$ нигде больше не используются, как и не используется более $`c`$, их можно удалить из кода, в итоге получая:
```haskell
import Control.Arrow (Arrow (first))
import Data.Char (chr)

main :: IO ()
main =
  putStrLn answer
  where
    answer = zipWith foo bar numbers
    foo = curry $ chr . uncurry (-) . first ((`mod` 1021) . length)
    bar = c1 : c2 : zipWith f bar (tail bar)

f :: Eq a => [a] -> [a] -> [a]
f x y
  | 512 >= length (a x y) = sb x y
  | length (a x y) >= 800 = a x y
  | otherwise = f x $ m x y

a :: Eq a => [a] -> [a] -> [a]
a x y | x == [] = y
a (x : xs) y = a xs (x : y)

sb :: Eq a => [b] -> [a] -> [b]
sb x y | y == [] = x
sb (_ : xs) (_ : ys) = sb xs ys

m :: (Eq a, Eq b) => [b] -> [a] -> [b]
m x y | y == [] = []
m x (y : ys) = a x $ m x ys

numbers = [153, 586, 819, 461, 354, 843, 263, 215, 564, 884, 548, 511, 139, 814, -16, 853, -73, 886, 921, 870, 926, 886, 784, 763, 589, 364, 20, 502, 650, 237, -49, 288, 373, 774, 203, 73, 378, 549, 4, 657, 777, 592, 396, 89, 543, 696, 322, 144, 562, 761, 304, 144, 546, 736, 307, 32, 436, 572, -4, 618, 715, 462, 245, 762, -2, 856, 965, 833, 734]

c1 = replicate 233 ()
c2 = replicate 666 ()
```

### **Функция $`f`$**

```haskell
f :: Eq a => [a] -> [a] -> [a]
f x y
  | 512 >= length (a x y) = sb x y
  | length (a x y) >= 800 = a x y
  | otherwise = f x $ m x y
```

Функция **$`f[x,y]`$** возвращает:
* $`sb[x,y]`$, если длина списка $`{a[x,y] \leq 512 }`$,
* $`a[x,y]`$, если длина списка $`{a[x,y] \geq 800 }`$,
* $`f[x, m(x,y)]`$ иначе.

Нетрудно заметить, что последнее условие никогда не выполняется, тогда его можно удалить. Функция $`m`$ нигде не используется, кроме невыполнимого сценария ветвления в функции $`f`$, поэтому её также можно удалить.

Список, возвращаемый функцией $`a[x,y]`$ и его длина используются в $`f`$ несколько раз, поэтому, учитывая ленивые вычисления в Haskell (и не учитывая оптимизации компилятора), их стоит отдельно вычислить и сохранить.

Принимая во внимание написанное выше, $`f`$ можно перезаписать как:
```haskell
f :: Eq a => [a] -> [a] -> [a]
f x y
  | 512 >= l = sb x y
  | l >= 800 = axy
  where
    axy = a x y
    l = length axy
```
Получая в итоге:
```haskell
import Control.Arrow (Arrow (first))
import Data.Char (chr)

main :: IO ()
main =
  putStrLn answer
  where
    answer = zipWith foo bar numbers
    foo = curry $ chr . uncurry (-) . first ((`mod` 1021) . length)
    bar = c1 : c2 : zipWith f bar (tail bar)

f :: Eq a => [a] -> [a] -> [a]
f x y
  | 512 >= l = sb x y
  | l >= 800 = axy
  where
    axy = a x y
    l = length axy

a :: Eq a => [a] -> [a] -> [a]
a x y | x == [] = y
a (x : xs) y = a xs (x : y)

sb :: Eq a => [b] -> [a] -> [b]
sb x y | y == [] = x
sb (_ : xs) (_ : ys) = sb xs ys

numbers = [153, 586, 819, 461, 354, 843, 263, 215, 564, 884, 548, 511, 139, 814, -16, 853, -73, 886, 921, 870, 926, 886, 784, 763, 589, 364, 20, 502, 650, 237, -49, 288, 373, 774, 203, 73, 378, 549, 4, 657, 777, 592, 396, 89, 543, 696, 322, 144, 562, 761, 304, 144, 546, 736, 307, 32, 436, 572, -4, 618, 715, 462, 245, 762, -2, 856, 965, 833, 734]

c1 = replicate 233 ()
c2 = replicate 666 ()
```

### **Функция $`sb`$**

```haskell
sb :: Eq a => [b] -> [a] -> [b]
sb x y | y == [] = x
sb (_ : xs) (_ : ys) = sb xs ys
```

Функция **$`sb (x:xs) (y:ys)`$** возвращает:
* $`(x:xs)`$, если данный список $`(y:ys)`$ пустой,
* $`sb[xs,ys]`$ иначе.

Из последнего пункта несложно заметить, что функция сокращает входные массивы, удаляя головы списков каждый раз, когда длина второго не равна нулю, то есть пока он не станет пустым.

Допустим, на вход подаются массивы $`a`$ и $`b`$ длин $`n`$ и $`m`$ соответственно, $`m_i`$ - массив $`m`$ без первых $`i`$ элементов. Тогда:
* если $`n > m`$: функция достигает момента, когда $`a_i`$ ещё содержит элементы, а $`b_i`$ пуст. Возвращается $`a_i`$, то есть список $`a`$ без первых $`i`$ элементов, где $`i = m`$.
* если $`n = m`$: функция достигает момента, когда оба списка $`a_i`$ и  $`b_i`$ пусты. Так как выполняется условие пустоты  $`b_i`$, возвращается $`a_i`$, то есть пустой список.
* если $`n < m`$: функция не определена.

Нетрудно заметить, что функция возвращает исходной массив $`a`$ без первых $`m`$ элементов. Тогда функцию можно перезаписать следующим образом:
```haskell
sb :: Eq a => [b] -> [a] -> [b]
sb x y = drop (length y) x
```

Функция используется в единственном месте -- функции $`f`$. Подставляя её туда, код приобретает следующую форму:
```haskell
import Control.Arrow (Arrow (first))
import Data.Char (chr)

main :: IO ()
main =
  putStrLn answer
  where
    answer = zipWith foo bar numbers
    foo = curry $ chr . uncurry (-) . first ((`mod` 1021) . length)
    bar = c1 : c2 : zipWith f bar (tail bar)

f :: Eq a => [a] -> [a] -> [a]
f x y
  | 512 >= l = drop (length y) x
  | l >= 800 = axy
  where
    axy = a x y
    l = length axy

a :: Eq a => [a] -> [a] -> [a]
a x y | x == [] = y
a (x : xs) y = a xs (x : y)

numbers = [153, 586, 819, 461, 354, 843, 263, 215, 564, 884, 548, 511, 139, 814, -16, 853, -73, 886, 921, 870, 926, 886, 784, 763, 589, 364, 20, 502, 650, 237, -49, 288, 373, 774, 203, 73, 378, 549, 4, 657, 777, 592, 396, 89, 543, 696, 322, 144, 562, 761, 304, 144, 546, 736, 307, 32, 436, 572, -4, 618, 715, 462, 245, 762, -2, 856, 965, 833, 734]

c1 = replicate 233 ()
c2 = replicate 666 ()
```


### **Функция $`a`$**

```haskell
a :: Eq a => [a] -> [a] -> [a]
a x y | x == [] = y
a (x : xs) y = a xs (x : y)
```

Функция **$`a (x:xs) y`$** возвращает:
* $`y`$, если данный список $`(x:xs)`$ пустой,
* $`a [xs, (x : y)]`$ иначе.

Проанализировав поведение функции, можно заметить, что она конкатенирует $`a [xs, (x : y)]`$ и голову списка $`x`$ со списком $`y`$, что рекурсивно переставляет на каждой итерации голову списка в конец и конкатенирует получившийся список со списком из предыдущей итерации, то есть голову $`x`$ с $`y`$, до момента, пока первый список не станет пустым (возвращаемый при этом пустой список не используется).

Очевидно, данная функция обращает первый список и конкатенирует его со вторымы. Тогда функцию можно перезаписать так:
```haskell
a :: Eq a => [a] -> [a] -> [a]
a x y = (reverse x) ++ y
```

Функция используется только в $`f`$, тогда код принимает вид:
```haskell
import Control.Arrow (Arrow (first))
import Data.Char (chr)

main :: IO ()
main =
  putStrLn answer
  where
    answer = zipWith foo bar numbers
    foo = curry $ chr . uncurry (-) . first ((`mod` 1021) . length)
    bar = c1 : c2 : zipWith f bar (tail bar)

f :: Eq a => [a] -> [a] -> [a]
f x y
  | 512 >= l = drop (length y) x
  | l >= 800 = axy
  where
    axy = (reverse x) ++ y
    l = length axy

numbers = [153, 586, 819, 461, 354, 843, 263, 215, 564, 884, 548, 511, 139, 814, -16, 853, -73, 886, 921, 870, 926, 886, 784, 763, 589, 364, 20, 502, 650, 237, -49, 288, 373, 774, 203, 73, 378, 549, 4, 657, 777, 592, 396, 89, 543, 696, 322, 144, 562, 761, 304, 144, 546, 736, 307, 32, 436, 572, -4, 618, 715, 462, 245, 762, -2, 856, 965, 833, 734]

c1 = replicate 233 ()
c2 = replicate 666 ()
```

### **Главная функция $`main`$**
```haskell
main :: IO ()
main =
  putStrLn answer
  where
    answer = zipWith foo bar numbers
    foo = curry $ chr . uncurry (-) . first ((`mod` 1021) . length)
    bar = c1 : c2 : zipWith f bar (tail bar)

f :: Eq a => [a] -> [a] -> [a]
f x y
  | 512 >= l = drop (length y) x
  | l >= 800 = axy
  where
    axy = (reverse x) ++ y
    l = length axy
```

Ответом является список пар списков $`bar`$ и $`numbers`$ с использоанием функции $`foo`$.

#### **Список $`bar`$**
```haskell
bar = c1 : c2 : zipWith f bar (tail bar)

f :: Eq a => [a] -> [a] -> [a]
f x y
  | 512 >= l = drop (length y) x
  | l >= 800 = axy
  where
    axy = (reverse x) ++ y
    l = length axy
```

Функция создаёт список пар из самого списка с его хвостом с функцией $`f`$. В функции $`f`$ сравнивается длина списка $`a(x,y)`$, полученная конкатенацией обратного списка $`x`$ с $`y`$. Тогда на первой же итерации длина получившегося списка будет $`{c_1 + c_2 = 233 + 666 = 899}`$, что больше $`800`$. Тогда условие $`{512 \geq l}`$ не будет выполняться никогда, и всегда возвращается массив, получаемый ранее описанной функцией.
```haskell
bar = c1 : c2 : zipWith f bar (tail bar)

f :: Eq a => [a] -> [a] -> [a]
f x y = (reverse x) ++ y
```

Несложно заметить, что функция создаёт массив из списков, размер которых равен сумме размеров двух предыдущих -- то есть последовательность длин данного списка является последовательностью Фибоначии с начальными значениями $`233`$ и $`666`$.

#### **Функция $`foo`$**
```haskell
foo = curry $ chr . uncurry (-) . first ((`mod` 1021) . length)
bar = c1 : c2 : zipWith f bar (tail bar)

f :: Eq a => [a] -> [a] -> [a]
f x y = (reverse x) ++ y
```

Функция берёт на вход два списка $`a`$ и $`b`$. Для первого берётся его длина, а затем от неё берётся остаток от деления на $`1021`$. Затем данное число отнимается от соответсвующего числа из второго массива. $`zipWith`$ ограничивает последовательность, получаемую $`f`$, длиной второго массива $`b`$. Получаемой список переводится в список $`char`$, равносильный строке, и выводится.

Очевидно, что для функции имеет значение только размер первого списка, а не его содержание, поэтому от создания списков можно избавиться в пользу создания списка размеров. Так как ранее было замечено, что длины есть числа Фибоначчи, то нужный список размеров будет просто последовательностью Фибоначии. Чтобы ускорить генерацию такого списка, необходимо избавиться от рекурсии, получая следующее:
```haskell
fibs' :: [Int]
fibs' = map fst $ iterate (\(x, y) -> (y, x + y)) (233, 666)

fibs :: Int -> [Int]
fibs n = take n fibs'
```

$`fibs'`$ создаёт бесконечную последовательность Фибоначчи, а $`fibs`$ возращает список из первых $`n`$ чисел Фибоначчи. Тогда код можно переписать так:
```haskell
import Control.Arrow (Arrow (first))
import Data.Char (chr)

main :: IO ()
main =
  putStrLn answer
  where
    answer = zipWith foo bar numbers
    foo = curry $ chr . uncurry (-) . first (`mod` 1021)
    bar = fibs (length numbers)

fibs' :: [Int]
fibs' = map fst $ iterate (\(x, y) -> (y, x + y)) (233, 666)

fibs :: Int -> [Int]
fibs n = take n fibs'

numbers = [153, 586, 819, 461, 354, 843, 263, 215, 564, 884, 548, 511, 139, 814, -16, 853, -73, 886, 921, 870, 926, 886, 784, 763, 589, 364, 20, 502, 650, 237, -49, 288, 373, 774, 203, 73, 378, 549, 4, 657, 777, 592, 396, 89, 543, 696, 322, 144, 562, 761, 304, 144, 546, 736, 307, 32, 436, 572, -4, 618, 715, 462, 245, 762, -2, 856, 965, 833, 734]
```

Также можно далее упростить функцию $`foo`$, возвращающую список из элементов $`char`$, получаемых конвертацией из ASCII-кода: стоит разделить
1. функционал перевода в `char` из ASCII-кода
2. нахождение разницы по модулю 1021.

Список получаемых кодов можно записать с помощью zipWith, аргументами которого будут `numbers` и бесконечый список `fibs'`, который сократится до длины первого; перевод в `char` можно сделать с операцией `map chr` по полученному на прошлом этапе списку.

Тогда, удаляя ненужные более модуль *Arrow* и функцию `fibs`, код сокращается до следующего: 
```haskell
import Data.Char (chr)

main :: IO ()
main = do
  let ascii = zipWith (\x y -> (x - y) `mod` 1021) fibs' numbers
  putStrLn $ map chr ascii

fibs' :: [Int]
fibs' = map fst $ iterate (\(x, y) -> (y, x + y)) (233, 666)

numbers = [153, 586, 819, 461, 354, 843, 263, 215, 564, 884, 548, 511, 139, 814, -16, 853, -73, 886, 921, 870, 926, 886, 784, 763, 589, 364, 20, 502, 650, 237, -49, 288, 373, 774, 203, 73, 378, 549, 4, 657, 777, 592, 396, 89, 543, 696, 322, 144, 562, 761, 304, 144, 546, 736, 307, 32, 436, 572, -4, 618, 715, 462, 245, 762, -2, 856, 965, 833, 734]
```

## Итог
После проведения вышеописанных оптимизация программа выводит в поток вывода следующую строку:
```PPPSD{haskell4life_p34n0_numbers_as_lists4w1n_e160d0248b93cdb092_1!1}```

Поставленная задача выполнена.
