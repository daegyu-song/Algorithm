package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ2606 {
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

    static void dfs(int x) {
        visit[x] = true;
        for (int i : field[x]) {
            if (!visit[i]) {
                cnt++;
                dfs(i);
            }
        }
    }

    static void pro() {
        dfs(1);
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
