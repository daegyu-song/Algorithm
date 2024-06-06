package topologicalsort;

import java.util.*;
import java.io.*;

class Node {
    int v;
    int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class BOJ2637 {
    static int N, M;
    static ArrayList<Node>[] field;
    static int[] indeg;
    static int[][] ans;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        indeg = new int[N + 1];
        ans = new int[N + 1][N + 1];

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
            field[y].add(new Node(x, k));
            indeg[x]++;
        }
    }

    static void pro() {
        Deque<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                ans[i][i] = 1;
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();

            for (Node y : field[x]) {
                int v = y.v;
                int w = y.w;

                indeg[v]--;

                for (int i = 1; i <= N; i++) {
                    ans[v][i] += ans[x][i] * w;
                }

                if (indeg[v] == 0) que.add(v);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (ans[N][i] != 0) {
                System.out.println(i + " " + ans[N][i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
