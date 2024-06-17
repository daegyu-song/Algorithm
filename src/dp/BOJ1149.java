package dp;

import java.io.*;
import java.util.*;

public class BOJ1149 {
    static int N;
    static int[][] price, dy;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        price = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }

        dy = new int[N + 1][3];
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            dy[i][0] = Math.min(dy[i - 1][1] + price[i][0], dy[i - 1][2] + price[i][0]);
            dy[i][1] = Math.min(dy[i - 1][0] + price[i][1], dy[i - 1][2] + price[i][1]);
            dy[i][2] = Math.min(dy[i - 1][0] + price[i][2], dy[i - 1][1] + price[i][2]);
        }

        System.out.println(Math.min(dy[N][0], Math.min(dy[N][1], dy[N][2])));
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}
