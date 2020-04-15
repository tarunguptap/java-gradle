package com.logical;


// A Perfect number is a positive integer that is equal to the sum of its proper divisors except itself. e.g : - 6 (+ve factor 1, 2 ,3 ,6, sum of all factors except number itself 1+2+3 = 6)
// Similarly, 28 = 1,2,4,7,14,28  . 496=1,2,4,8,16,31,62,124,248,496
public class perfectnumber {
    public static void main(String[] args) {
        // long n = 496;

        for (int n = 0; n < 1000; n++) {
            int i = 1;
            long sum = 0;
            while (i <= n / 2) {
                if (n % i == 0) {
                    sum += i;
                }
                i++;
            }
            if (sum == n) {
                System.out.println(n + " is a perfect number");
            }
        }

    }
}
