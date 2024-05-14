package graphsearch;

import java.util.*;
import java.io.*;

class State {
    int[] x;

    public State(int[] x) {
        this.x = new int[3];
        for (int i = 0; i < 3; i++) this.x[i] = x[i];
    }

    State move(int from, int to, int[] limit) {
        int[] nx = new int[] {x[0], x[1], x[2]};
        if (x[from] + x[to] >= limit[to]) {
            nx[from] -= limit[to] - x[to];
            nx[to] = limit[to];
        } else {
            nx[to] += nx[from];
            nx[from] = 0;
        }
        return new State(nx);
    }
}

public class BOJ2251 {
    static boolean[][][] visit;
    static boolean[] possible;
    static int[] limit;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit = new int[3];
        for (int i = 0; i < 3; i++) limit[i] = Integer.parseInt(st.nextToken());
        visit = new boolean[205][205][205];
        possible = new boolean[205];
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
                    State nx = st.move(from, to, limit);

                    if (!visit[nx.x[0]][nx.x[1]][nx.x[2]]) {
                        visit[nx.x[0]][nx.x[1]][nx.x[2]] = true;
                        que.add(nx);
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
