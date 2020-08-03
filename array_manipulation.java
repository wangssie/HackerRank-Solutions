//https://www.hackerrank.com/challenges/crush/problem?h_r=profile
//level: hard

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] A = new long[n];

        //ArrayList<Integer> A = new ArrayList<Integer>();
        /*
        for (int i=0; i<n; i++) {
            A.add(0);
        }
        */
        long max = 0, temp = 0;
        int lBound, rBound;
        long add;
        for (int i=0; i<queries.length; i++) {
            lBound = queries[i][0];
            rBound = queries[i][1];
            add = queries[i][2];

            A[lBound-1] += add;
                if (rBound<n) {
                A[rBound] -= add;
            }
        }

        for (int i=0; i<n; i++) {
            temp += A[i];
            if (temp>max) {
                max = temp;
            }
        }

        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
