package topologicalsort;

import java.util.*;
import java.io.*;

public class BOJ9470 {
    static int K, M, P;
    static ArrayList<Integer>[] field, max;
    static int[] indeg, sequence;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        field = new ArrayList[M + 1];
        max = new ArrayList[M + 1];
        indeg = new int[M + 1];
        sequence = new int[M + 1];

        for (int i = 0; i <= M; i++) {
            field[i] = new ArrayList<>();
            max[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            indeg[y]++;
        }
    }

    static void solution(int y) {
        int ans = 0, cnt = 0;
        for (int i = 0; i < max[y].size(); i++) {
            if (max[y].get(i) > ans) {
                ans = max[y].get(i);
            }
        }

        for (int i = 0; i < max[y].size(); i++) {
            if (max[y].get(i) == ans) {
                cnt++;
            }
        }

        if (cnt >= 2) {
            sequence[y] = ans + 1;
        } else {
            sequence[y] = ans;
        }
    }

    static void pro() {
        Deque<Integer> que = new LinkedList<>();

        for (int i = 1; i <= M; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                sequence[i] = 1;
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : field[x]) {

                indeg[y]--;
                max[y].add(sequence[x]);
                if (indeg[y] == 0) {
                    solution(y);
                    que.add(y);
                }
            }
        }

        Arrays.sort(sequence);
        System.out.println(K + " " + sequence[sequence.length - 1]);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
    }
}
