// https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_r=profile
// level: medium

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        for (int i=1; i<s.length(); i++) {
            // create dict for i substring length
            HashMap<String, Integer> dict = new HashMap();
            for (int j=0; j<=s.length()-i; j++) {
                // get substring and sort
                String sub = s.substring(j, j+i);
                char temp[] = sub.toCharArray();
                Arrays.sort(temp);
                sub = new String(temp);
                // check if substring exists in dict
                if (dict.containsKey(sub)) {
                    int freq = dict.get(sub);
                    count+=freq;
                    dict.put(sub, freq+1);
                }
                else {
                    dict.put(sub, 1);
                }
            }
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
