package org.practice.algorithms.misc;

/*
Given an array A of positive integers {n, n+1, n+2, …, m-2, m-1, m},
write a function that will return sum of all integers in the array.

Examples: If A = {1, 2, 3, 4, 5}, then the function will return 15 because 1 + 2 + 3 + 4 + 5 => 15.
*/
public class SumOfSeq {
    public static void main(String[] args) {
        assert sumOfSeq(null) == 0;

        int[] seq = new int[]{};
        assert sumOfSeq(seq) == 0;

        seq = new int[] {1, 2, 3, 4, 5};
        assert sumOfSeq(seq) == 15;

        seq = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assert sumOfSeq(seq) == 55;
    }

    public static int sumOfSeq(int[] seq) {
        if (seq == null) {
            return 0;
        }

        int sum = 0;
        for (int num : seq) {
            sum += num;
        }
        return sum;
    }
}
