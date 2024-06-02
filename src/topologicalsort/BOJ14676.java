package topologicalsort;

import java.util.*;
import java.io.*;

public class BOJ14676 {
    static int N, M, K;
    static ArrayList<Integer>[] field;
    static int[] indeg, build, check;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        indeg = new int[N + 1];
        build = new int[N + 1];
        check = new int[N + 1];

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() throws IOException {
        StringTokenizer st;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            if (x == 1) {
                if (check[y] < indeg[y]) {
                    System.out.println("Lier!");
                    return;
                }

                build[y]++;
                if (build[y] == 1) {
                    for (int k : field[y]) {
                        check[k]++;
                    }
                }
            } else {
                if (build[y] == 0) {
                    System.out.println("Lier!");
                    return;
                }
                build[y]--;
                if (build[y] == 0) {
                    for (int k : field[y]) {
                        check[k]--;
                    }
                }
            }
        }
        System.out.println("King-God-Emperor");
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
