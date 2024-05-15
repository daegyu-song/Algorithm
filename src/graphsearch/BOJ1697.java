package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ1697 {
    static int start, end;
    static int[] field, dist;
    static int[] dir = {1, -1, 2};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        field = new int[100001];
        dist = new int[100001];
        Arrays.fill(dist, -1);
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        dist[start] = 0;

        while (!que.isEmpty()) {
            int x = que.poll();
            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if (i == 2) {
                    nx = x * dir[i];
                } else {
                    nx = x + dir[i];
                }

                if (nx < 0 || nx > field.length - 1) continue;
                if (dist[nx] != -1) continue;

                que.add(nx);
                dist[nx] = dist[x] + 1;
            }
        }
    }

    static void pro() {
        bfs();
        System.out.println(dist[end]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
