package graphsearch;

import java.io.*;
import java.util.*;

public class BOJ13549 {
    static int n, k;
    static int[] dist;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int y : new int[]{1, -1, 2}) {
                if (y == 1 || y == -1) {
                    if (x + y < 0 || x + y > 100000) continue;
                    if (dist[x + y] <= dist[x] + 1) continue;
                } else {
                    if (x * y < 0 || x * y > 100000) continue;
                    if (dist[x * y] <= dist[x]) continue;
                }

                if (y == 1 || y == -1) {
                    queue.add(x + y);
                    dist[x + y] = dist[x] + 1;
                } else {
                    queue.add(x * y);
                    dist[x * y] = dist[x];
                }
            }
        }
    }

    static void pro() {
        bfs(n);
        System.out.println(dist[k]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
