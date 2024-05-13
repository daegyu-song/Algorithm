package backtracking;

import java.util.*;
import java.io.*;

public class BOJ14889 {
    static int N;
    static boolean[] selected;
    static int[][] table;
    static int min = Integer.MAX_VALUE;

    static void sub() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    startTeam += table[i][j];
                    startTeam += table[j][i];
                }
                else if (!selected[i] && !selected[j]) {
                    linkTeam += table[i][j];
                    linkTeam += table[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(startTeam - linkTeam));
        if (min == 0) {
            System.out.println(min);
            System.exit(0);
        }
    }

    static void solution(int index, int k) {
        if (k == N / 2) {
            sub();
        } else {
            for (int i = index; i < N; i++) {
                if (!selected[i]) {
                    selected[i] = true;
                    solution(i + 1, k + 1);
                    selected[i] = false;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        table = new int[N][N];
        selected = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);
        System.out.println(min);
    }
}
