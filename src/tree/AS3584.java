package tree;

import java.util.*;
import java.io.*;

public class AS3584 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] field, check;

    static void input() throws IOException{
        N = Integer.parseInt(br.readLine());

        field = new int[N + 1];
        check = new int[N + 1];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[y] = x;
        }
    }

    static void pro() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

        while (x > 0) {
            check[x] = 1;
            x = field[x];
        }

        while (y > 0 && check[y] == 0) {
            y = field[y];
        }
        System.out.println(y);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
    }
}
