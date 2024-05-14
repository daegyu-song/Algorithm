package graphsearch;

import java.util.*;
import java.io.*;

public class AS2606 {
    static int computer, connect, cnt;
    static ArrayList<Integer>[] field;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer = Integer.parseInt(br.readLine());
        connect = Integer.parseInt(br.readLine());
        field = new ArrayList[computer + 1];
        for (int i = 0; i < field.length; i++) {
            field[i] = new ArrayList<>();
        }
        for (int i = 0; i < connect; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            field[y].add(x);
        }
        visit = new boolean[computer + 1];
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : field[x]) {
                if (visit[y]) continue;

                cnt++;
                que.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro() {
        bfs(1);
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
