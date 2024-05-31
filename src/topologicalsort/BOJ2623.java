package topologicalsort;

import java.util.*;
import java.io.*;

public class BOJ2623 {
    static int N, M;
    static ArrayList<Integer>[] field;
    static int[] indeg;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indeg = new int[N + 1];

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int[] arr = new int[t];
            for (int j = 0; j < t; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            // 1 -> 4 -> 3
            for (int j = 0; j < t - 1; j++) {
                if (field[arr[j]].contains(arr[j + 1])) continue;
                field[arr[j]].add(arr[j + 1]);
                indeg[arr[j + 1]]++;
            }
        }
    }

    static void pro() {
        Deque<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            sb.append(x).append("\n");

            for (int y : field[x]) {

                indeg[y]--;
                if (indeg[y] == 0) que.add(y);
            }
        }
    }

    static void output() {
       for (int i = 1; i <= N; i++) {
           if (indeg[i] != 0) {
               System.out.println(0);
               return;
           }
       }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        output();
    }
}
