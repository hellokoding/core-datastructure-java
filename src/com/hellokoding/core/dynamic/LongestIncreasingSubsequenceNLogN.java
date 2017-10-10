package com.hellokoding.core.dynamic;

public class LongestIncreasingSubsequenceNLogN
{
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        int[] tailTable   = new int[size];
        int len;

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len-1])
                tailTable[len++] = A[i];

            else
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }

        return len;
    }

    public static void main(String[] args)
    {
        int A[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is "+
                LongestIncreasingSubsequenceLength(A, n));
    }
}