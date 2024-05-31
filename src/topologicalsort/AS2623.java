package topologicalsort;

import java.util.*;

public class AS2623 {
    static int N, M;
    static ArrayList<Integer>[] field;
    static ArrayList<Integer> ans;
    static int[] indeg;
    static StringBuilder sb = new StringBuilder();

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        indeg = new int[N + 1];

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int cnt = sc.nextInt(), x = sc.nextInt(), y;

            for (int j = 1; j < cnt; j++) {
                y = sc.nextInt();
                field[x].add(y);
                indeg[y]++;
                x = y;
            }
        }
    }

    static void pro() {
        Deque<Integer> que = new LinkedList<>();
        ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            ans.add(x);

            for (int y : field[x]) {

                indeg[y]--;
                if (indeg[y] == 0) que.add(y);
            }
        }
    }

    static void output() {
        if (ans.size() == N) for (int i : ans) sb.append(i).append("\n");
        else sb.append(0);

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
        output();
    }
}
