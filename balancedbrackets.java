//https://www.hackerrank.com/challenges/balanced-brackets/problem?h_r=profile
//medium

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char c;
        for (int i=0; i<s.length(); i++) {
            switch(s.charAt(i)) {
                case '(':
                    c = ')';
                    break;
                case '[':
                    c= ']';
                    break;
                case '{':
                    c = '}';
                    break;
                default:
                    c = ' ';
                    break;

            }
            if (c!=' ') {
                stack.addFirst(c);
            }
            else {
                if (stack.isEmpty() || !((Character)s.charAt(i)).equals(stack.pop())) {
                    return "NO";
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        }
        else {
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
