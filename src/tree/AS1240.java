package tree;

import java.util.*;
import java.io.*;

public class AS1240 {
    static class Area {
        int y, z;
        public Area(int y, int z) {
            this.y = y;
            this.z = z;
        }
    }

    static int N, M, ans;
    static ArrayList<Area>[] field;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), z = Integer.parseInt(st.nextToken());
            field[x].add(new Area(y, z));
            field[y].add(new Area(x, z));
        }
    }

    static void dfs(int x, int prev, int goal, int dist) {
        if (x == goal) {
            ans = dist;
            return;
        }

        for (Area a : field[x]) {
            // 되돌아가기 금지
            if (a.y == prev) continue;
            dfs(a.y, x, goal, dist + a.z);
        }
    }

    static void pro() throws IOException {
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            dfs(x, -1, y, 0);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}
