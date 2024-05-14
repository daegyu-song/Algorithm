package graphsearch;

import java.util.*;
import java.io.*;

public class AS2251 {
    static boolean[][][] visit;
    static boolean[] possible;
    static int[] limit;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        visit = new boolean[201][201][201];
        possible = new boolean[201];
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> que = new LinkedList<>();
        visit[x1][x2][x3] = true;
        que.add(new State(new int[] {x1, x2, x3}));

        while (!que.isEmpty()) {
            State st = que.poll();
            if (st.x[0] == 0) possible[st.x[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    State nst = st.move(from, to, limit);
                    if (!visit[nst.x[0]][nst.x[1]][nst.x[2]]) {
                        que.add(nst);
                        visit[nst.x[0]][nst.x[1]][nst.x[2]] = true;
                    }
                }
            }
        }
    }

    static void pro() {
        bfs(0, 0, limit[2]);
        for (int i = 0; i <= limit[2]; i++) {
            if (possible[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
