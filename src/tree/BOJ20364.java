package tree;

import java.util.*;
import java.io.*;

public class BOJ20364 {
    static int N, Q;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
    }

    static void pro() throws IOException {
        for (int i = 0; i < Q; i++) {
            int x = Integer.parseInt(br.readLine());
            int y = x;

            int ans = 0;
            while (x > 0) {
                if (visit[x]) ans = x;
                x /= 2;
            }
            visit[y] = true;
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
