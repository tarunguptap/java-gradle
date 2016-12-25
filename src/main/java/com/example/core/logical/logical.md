# String

## 1  There's pool of 100 balls, numbered from 1 to 100. One guy randomly picked one ball ran away. How will i find the missing ball. or To find the missing number from 1 to 100
Solution1 : will first sort the balls in an array, then will perform the binary search
Solution2 : sum of n natural numbers is n*(n+1)/2(where n is highest number). so we will get the difference of actual sum with it then we will get the desired number

## To find the duplicate number
Solution: sum of n natural numbers is n*(n+1)/2(where n is highest number). so we will get the difference of actual sum with it then we will get the desired number

## 2 How to find the fastest 3 horses out of 25 horse. In each race, only 5 horses can run at the same time because there are only 5 tracks.
Solution : We will get five fastest horses from 5 races. Then we will have a race of fastest five horses to get first 3 fastest horses. 

## 3 There is a building with 100 floors. You are given 2 identical eggs. The most interesting property of the eggs is that every egg has it’s own “threshold” floor. Let’s call that floor N. What this means is that the egg will not break when dropped from any floor below floor N, but the egg will definitely break from any floor above floor N, including floor N itself.
Solution : we start by dropping one of the eggs on the 10th floor: if it doesn’t break then we continue on to the 20th floor, then 30th, 40th… up to 100 in intervals of 10 until the first egg actually breaks. If the egg breaks on the 10th floor. We can take the 2nd egg and drop it from the first floor. If it does not break on the first floor, but it does break on the 2nd floor, then we know that the 2nd floor is the “threshold” floor.

## I have two array [1,2,3,4,5] and [1,6,7,8,9,3]. How to find the intersaction of the two array e.g: output should be [1,3]

## http://javaconceptoftheday.com/java-puzzle-interview-program-find-missing-number-in-an-array/
