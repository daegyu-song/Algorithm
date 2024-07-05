package graphsearch;

import java.io.*;
import java.util.*;

public class BOJ20165 {
    static int N, M, R, cnt;
    static int[][] originalField, copyField;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        originalField = new int[N + 1][M + 1];
        copyField = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                originalField[i][j] = Integer.parseInt(st.nextToken());
                copyField[i][j] = originalField[i][j];
            }

        }
    }

    static void dfs(int x, int y, String dir) {
        switch (dir) {
            case "E":
                if (x < 1 || x > N || y < 1 || y > M) break;
                if (copyField[x][y] == 0) break;

                for (int i = 1; i < copyField[x][y]; i++) {
                    dfs(x, y + i, "E");
                }

                copyField[x][y] = 0;
                cnt++;

            case "W":
                if (x < 1 || x > N || y < 1 || y > M) break;
                if (copyField[x][y] == 0) break;

                for (int i = 1; i < copyField[x][y]; i++) {
                    dfs(x, y - i, "W");
                }
                copyField[x][y] = 0;
                cnt++;

            case "S":
                if (x < 1 || x > N || y < 1 || y > M) break;
                if (copyField[x][y] == 0) break;

                for (int i = 1; i < copyField[x][y]; i++) {
                    dfs(x + i, y, "S");
                }
                copyField[x][y] = 0;
                cnt++;

            case "N":
                if (x < 1 || x > N || y < 1 || y > M) break;
                if (copyField[x][y] == 0) break;

                for (int i = 1; i < copyField[x][y]; i++) {
                    dfs(x - i, y, "N");
                }
                copyField[x][y] = 0;
                cnt++;
        }
    }

    static void pro() throws IOException {
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            dfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            copyField[x][y] = originalField[x][y];

        }

        System.out.println(cnt);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(copyField[i][j] != 0 ? "S" : "F");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
