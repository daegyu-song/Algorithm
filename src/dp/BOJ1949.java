package dp;

import java.util.*;
import java.io.*;

public class BOJ1949 {
    static int N;
    static ArrayList<Integer>[] field;
    static int[] numbers;
    static int[][] dy;


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        field = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            field[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            field[y].add(x);
        }

        dy = new int[N + 1][2];
    }

    static void dfs(int x, int prev) {
        dy[x][1] = numbers[x];
        for (int y: field[x]) {
            if (y == prev) continue;
            dfs(y, x);
            dy[x][0] += Math.max(dy[y][0], dy[y][1]);
            dy[x][1] += dy[y][0];
        }
    }

    static void pro() {
        dfs(1, -1);

        System.out.println(Math.max(dy[1][0], dy[1][1]));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
