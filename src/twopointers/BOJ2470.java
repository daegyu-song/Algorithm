package twopointers;

import java.io.*;
import java.util.*;

public class BOJ2470 {
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

    static void process() {
        Arrays.sort(solution);
        int zeroAbs = Integer.MAX_VALUE;
        int L = 0, R = N - 1, a1 = 0, a2 = 0;

        while (L < R) {
            if (Math.abs(solution[L] + solution[R]) < zeroAbs) {
                zeroAbs = Math.abs(solution[L] + solution[R]);
                a1 = solution[L];
                a2 = solution[R];
            }
            if (solution[L] + solution[R] > 0) R--;
            else L++;
        }
        System.out.println(a1 + " " + a2);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
