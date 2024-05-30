package topologicalsort;

import java.util.*;
import java.io.*;

public class BOJ2252 {
    static int N, M;
    static int[] in;
    static ArrayList<Integer>[] field;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        in = new int[N + 1];

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            in[y]++;
        }
    }

    static void pro() {
        Deque<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            sb.append(x).append(" ");

            for (int y : field[x]) {
                in[y]--;
                if (in[y] == 0) que.add(y);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
