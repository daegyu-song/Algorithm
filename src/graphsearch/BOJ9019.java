package graphsearch;

import java.io.*;
import java.util.*;

public class BOJ9019 {
    static int start, end;
    static boolean[] visit;
    static String[] DSLR;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        visit = new boolean[10000];
        DSLR = new String[10000];
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Arrays.fill(DSLR, "");
        visit[start] = true;

        while (!queue.isEmpty() && !visit[end]) {
            int x = queue.poll();

            int D = (2 * x) % 10000;
            int S = x == 0 ? 9999 : x - 1;
            int L = (x % 1000) * 10 + x / 1000;
            int R = (x % 10) * 1000 + x / 10;

            if (!visit[D]) {
                queue.add(D);
                visit[D] = true;
                DSLR[D] += DSLR[x] + "D";
            }
            if (!visit[S]) {
                queue.add(S);
                visit[S] = true;
                DSLR[S] += DSLR[x] + "S";
            }
            if (!visit[L]) {
                queue.add(L);
                visit[L] = true;
                DSLR[L] += DSLR[x] + "L";
            }
            if (!visit[R]) {
                queue.add(R);
                visit[R] = true;
                DSLR[R] += DSLR[x] + "R";
            }
        }
        System.out.println(DSLR[end]);
    }

    static void pro() {
        bfs(start);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            input();
            pro();
        }
    }
}
