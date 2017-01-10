# Binary Search

Binary search is a fast search algorithm with run-time complexity of O(log n). It works on the principle of divide and conquer. The data collection should be in the sorted form

## How Binary Search Works?
10 14 19 26 27 31 33 35 42 44
let us assume that we need to search the location of value 31 using binary search.
we shall determine half of the array.
If element of array at mid location is matching with the element to be searched then ok else if its greater than the element to be searched that means the desired element to be searched lies in the first part else its in second part. This way we will get the new first, last or mid
![alt tag](https://github.com/tarunguptap/java-gradle/blob/master/src/main/java/com/example/core/logical/search/binary_search_0.jpg)