package backtracking;

import java.util.*;
import java.io.*;

public class BOJ14888 {
    static int[] numbers;
    static int[] operators;
    static int[] solve;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void solution(int k) {
        if (k == numbers.length - 1) {
            int answer = numbers[0];
            for (int i = 0; i < solve.length; i++) {
                switch (solve[i]) {
                    case 0:
                        answer += numbers[i + 1];
                        break;
                    case 1:
                        answer -= numbers[i + 1];
                        break;
                    case 2:
                        answer *= numbers[i + 1];
                        break;
                    default:
                        answer /= numbers[i + 1];
                }
            }
            if (max < answer) max = answer;
            if (min > answer) min = answer;
        } else {
            for (int i = 0; i < operators.length; i++) {
                if (operators[i] == 0) continue;
                solve[k] = i;
                operators[i] -= 1;
                solution(k + 1);
                solve[k] = 0;
                operators[i] += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numbers = new int[Integer.parseInt(br.readLine())];
        operators = new int[4];
        solve = new int[numbers.length - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        //process
        solution(0);

        //output
        System.out.println(max + "\n" + min);
    }
}
