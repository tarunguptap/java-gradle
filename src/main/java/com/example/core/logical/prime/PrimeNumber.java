package com.example.core.logical.prime;

/**
 * Prime Number : A number that can't be divided evenly by numbers other than 1 or itself. 
 * Composite Number : A whole number that can be divided evenly by numbers other than 1 or itself. 
 * Note: 0 and 1 are not prime numbers. 
 * The 2 is the only even prime number because 
 * all the other even numbers can be divided by 2.
 * @author 
 *
 */
public class PrimeNumber {
	
	public static void main(String[] args) {
		System.out.println("Prime1 : "+isPrimeNumber1(35));
		System.out.println("Prime2 : "+isPrimeNumber2(35));
		System.out.println("Prime3 : "+isPrimeNumber3(35));
		printAllPrimeNumbers(100);
	}
	
	
	/** To check whether the passes number is prime or not
	 * Trivially, we can check every integer from 1 to itself (exclusive) and test whether it divides evenly.
	 * @param Number
	 * @return
	 */
	public static boolean isPrimeNumber1(int Number) {
		for (int i = 2; i < Number; i++) {
			if (((Number % i) == 0)) {
				return false;
			}
		}
		System.out.print(Number + " ");
		return true;
	}
	
	/** To check whether the passes number is prime or not
	 * but we can make it faster - much faster. Consider that if 2 divides some integer n, 
	 * then (n/2) divides n as well.
	 * @param Number
	 * @return
	 */
	public static boolean isPrimeNumber2(int Number) {
		for (int i = 2; i <= Number/2; i++) {
			if (((Number % i) == 0)) {
				return false;
			}
		}
		System.out.print(Number + " ");
		return true;
	}
	
	/** To check whether the passes number is prime or not
	 * With some more efficient coding,we notice that you really only have to go up to the square root of n, 
	 * because if you list out all of the factors of a number, the square root will always be in the middle 
	 * we know 2 is the "oddest" prime - it happens to be the only even prime number.
	 * Because of this, we need only check 2 separately, then traverse odd numbers up to the square root of n.
	 * @param number
	 * @return
	 */
	public static boolean isPrimeNumber3(int number) {
		if(number == 2) return true;
		//check if n is a multiple of 2
	    if (number%2==0) return false;
	    int sqrtn=(int)Math.sqrt(number);
	    //if not, then just check the odds
		for (int i = 3; i <= sqrtn; i+=2) {
			if (((number % i) == 0)) {
				return false;
			}
		}
		System.out.print(number + " ");
		return true;
	}
	
	/**
	 * We can implement some way e.g if for 3 number is not prime then we can skip the checking with multiples of 3
	 * @param Number
	 * @return
	 */
	public static boolean isPrimeNumber4(int Number) {
		//TODO
		return false;
	}
	
	private static void printAllPrimeNumbers(int limit) {
		System.out.println("Prime numbers between 1 and " + limit);
		for (int i = 2; i < limit; i++) {
			isPrimeNumber1(i);
		}
		System.out.println("");
		for (int i = 2; i < limit; i++) {
			isPrimeNumber2(i);
		}
		System.out.println("");
		for (int i = 2; i < limit; i++) {
			isPrimeNumber3(i);
		}
	}
}
