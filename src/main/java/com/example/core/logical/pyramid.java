package com.example.core.logical;
//http://codescracker.com/java/program/java-program-print-pascal-triangle.htm
public class pyramid {

    public static void main(String[] args) {
    	RightAlignedAsteriskHalfPyramid(6);
        numberPyramid(6);
        leftAlignedInvertedPyramid(6);
        leftAlignedNumericPyramid(6);
        leftAlignedAlphabeticPyramid(6);
        floydTriangle(6);
        System.out.println("Astriek pyramid");
        asteriskPyramid(6);
        System.out.println("Reverse Astriek pyramid");
        invertedAsterikPyramid(6);
        System.out.println("Astriek diamond");
        printDiamond(6);
        pascalTriangle(6);
        
    }

    private static void RightAlignedAsteriskHalfPyramid(int numberOfLayer) {
    /*
     	   *
	      **
	     ***
	    ****
	   *****
	  ******
	 *******
     */
    	for (int i = 0; i <= numberOfLayer; i++) {
			for (int space = 0; space <= numberOfLayer-i; space++) {
				System.out.print(" ");
			}
			for (int asterik = 0; asterik <= i; asterik++) {
				System.out.print("*");
			}
			System.out.println();
		}
    }
    
    
    
    private static void numberPyramid(int numberOfLayer) {
    /*
    	     1
		    121
		   12321
		  1234321
		 123454321 
    */
    	for (int i = 1; i < numberOfLayer; i++) {
			for(int space=1; space<=numberOfLayer-i; space++) {
				System.out.print(" ");
			}
			for(int numeric = 1; numeric <= i; numeric++) {
				System.out.print(numeric);
			}
			for(int numeric = 1; numeric <= i-1; numeric++) {
				System.out.print(numeric);
			}
			System.out.println();
		}
    }
    
    private static void leftAlignedInvertedPyramid(int numberOfLayer) {
	/*
	 	* * * * *
		* * * *
		* * * 
		* *
		*
	 */
    	
    	for (int i = 1; i < numberOfLayer; i++) {
    		for (int asterik = 1; asterik <= numberOfLayer-i; asterik++) {
				System.out.print("*");
			}
			System.out.println();
		}
    }
    
    private static void leftAlignedNumericPyramid(int numberOfLayer) {
    /*
     	1
		1 2
		1 2 3
		1 2 3 4
		1 2 3 4 5
     */
    	for (int i = 0; i < numberOfLayer; i++) {
			for (int numeric = 1; numeric <= i; numeric++) {
				System.out.print(numeric);
			}
			System.out.println();
		}
    }
    
    private static void leftAlignedAlphabeticPyramid(int numberOfLayer) {
    /*	A
    	B B
    	C C C
    	D D D D
    	E E E E E
    */
    }
    
    
    
    private static void floydTriangle(int numberOfLayer) {
    	System.out.println("Floyd Triangle");
    /*	
	    1
		2 3
		4 5 6
		7 8 9 10
    */
    	int counter = 1;
    	for (int i = 1; i < numberOfLayer; i++) {
			for (int numeric = 1; numeric <= i; numeric++) {
				System.out.print(counter++ +" ");
			}
			System.out.println();
		}
    }
    
    
    private static void asteriskPyramid(int numberOfLayer) {
        /*
        	 	 *
    		    ***
    		   *****
    		  *******
    		 *********
    		***********
        */
            for (int i = 1; i <= numberOfLayer; i++) {// Total number of layer for pyramid
                for (int space = 1; space <= (numberOfLayer - i); space++) {
                    // Loop For Space
                    System.out.print(" ");
                }
                for (int asterik = 1; asterik <= i; asterik++) {
    	            // increase the value
    	            System.out.print("*");
                }
             // on commenting this loop half pyramid will print
                for (int asterik = 1 ; asterik <= i-1; asterik++) {
                    // decrease the value
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    
    private static void invertedAsterikPyramid(int numberOfLayer) {
    /*	
         * * * * * * * * * *
            * * * * * * *
         	  * * * * *
         		* * *
         		  *
    */
    	for (int i = 1; i <= numberOfLayer; i++) {
			for (int space = 1; space < i; space++) {
				System.out.print(" ");
			}
			for (int numeric = 1; numeric <=numberOfLayer-i+1; numeric++) {
				System.out.print("*");
			}
			for (int numeric = 1; numeric <=numberOfLayer-i; numeric++) {
				System.out.print("*");
			}
			System.out.println();
		}
    }
    
    private static void printDiamond(int numberOfLayer) {
    /*
     		 *
		    ***
		   *****
		  *******
		 *********
		***********
		***********
		 *********
		  *******
		   *****
		    ***
		     *
     */
    	asteriskPyramid(numberOfLayer);
    	invertedAsterikPyramid(numberOfLayer);
    }
    
    private static void pascalTriangle(int numberOfLayer) {
    	System.out.println("Pascal Triangle");
    /*	
	           1
	         1   1
	       1   2   1
	     1   3   3    1
	   1  4    6   4   1
	 1  5   10   10  5   1
    */
    	for (int i = 0; i < numberOfLayer; i++) {
			for (int space = 0; space < numberOfLayer-i; space++) {
				System.out.print(".");
			}
			int number = 1;
			for (int data = 0; data <= i; data++) {
				System.out.print(number + " ");
				number = number*(i-data) /(data+1);
			}
			System.out.println();
		}
    }
}
