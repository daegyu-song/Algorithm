package topologicalsort;

import java.util.*;
import java.io.*;

public class AS9470 {
    static int K, M, P;
    static ArrayList<Integer>[] field;
    static int[] indeg, sequence, maxCnt;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        field = new ArrayList[M + 1];
        indeg = new int[M + 1];
        sequence = new int[M + 1];
        maxCnt = new int[M + 1];

        for (int i = 0; i <= M; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        Deque<Integer> que = new LinkedList<>();


        for (int i = 1; i <= M; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                sequence[i] = maxCnt[i] = 1;
            }
        }

        int ans = 0;
        while (!que.isEmpty()) {
            int x = que.poll();

            if (maxCnt[x] >= 2) sequence[x]++;
            ans = Math.max(ans, sequence[x]);
            for (int y : field[x]) {

                indeg[y]--;
                if (indeg[y] == 0) que.add(y);

                if (sequence[y] < sequence[x]) {
                    sequence[y] = sequence[x];
                    maxCnt[y] = 1;
                } else if (sequence[y] == sequence[x]) maxCnt[y]++;
            }
        }
        System.out.println(K + " " + ans);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
    }
}
