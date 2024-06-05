package topologicalsort;

import java.util.*;
import java.io.*;

public class BOJ2056 {
    static int N;
    static ArrayList<Integer>[] field;
    static int[] indeg, minTime, buildTime;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        indeg = new int[N + 1];
        minTime = new int[N + 1];
        buildTime = new int[N + 1];

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                field[Integer.parseInt(st.nextToken())].add(i);
                indeg[i]++;
            }
        }
    }

    static void pro() {
        Deque<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                minTime[i] = buildTime[i];
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : field[x]) {

                indeg[y]--;
                minTime[y] = Math.max(minTime[y], minTime[x] + buildTime[y]);

                if (indeg[y] == 0) que.add(y);
            }
        }

        Arrays.sort(minTime);
        System.out.println(minTime[minTime.length - 1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

}
