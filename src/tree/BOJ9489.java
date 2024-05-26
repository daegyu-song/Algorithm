package tree;

import java.util.*;
import java.io.*;

public class BOJ9489 {
    static int n, k;
    static int[] field, check;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == 0 && k == 0) return;

        field = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }

        check = new int[n + 1];
    }

    static void pro() {
        check[0] = -1;
        check[1] = 0;

        int prev = 1;
        for (int i = 2; i <= n; i++, prev++) {
            for(; i <= n; i++) {
                check[i] = prev;
                if (i < n  && field[i] + 1 != field[i + 1]) break;
            }
        }

        int idx = 0;
        for (int i = 1; i <= n; i++) if (field[i] == k) idx = i;

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check[check[i]] == check[check[idx]] && check[i] != check[idx]) ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        while (true) {
            input();
            if (n == 0 && k == 0) break;
            pro();
        }
    }
}
