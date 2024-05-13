package twopointers;

import java.io.*;
import java.util.*;

public class BOJ2473 {
    static int N;
    static int[] solution;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solution = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < solution.length; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        long zeroAbs = Long.MAX_VALUE;
        int a = 0, b = 0, c = 0;
        Arrays.sort(solution);

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1, right = N - 1;
            while (left < right) {
                long checkAbs = (long)solution[left] + solution[right] + solution[i];
                if (Math.abs(checkAbs) < zeroAbs) {
                    zeroAbs = Math.abs(checkAbs);
                    a = solution[i];
                    b = solution[left];
                    c = solution[right];
                }
                if (checkAbs > 0) right--;
                else left++;
            }
        }
        System.out.print(a + " " + b + " " + c);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}
