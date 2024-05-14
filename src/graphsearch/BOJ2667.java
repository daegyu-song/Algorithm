package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ2667 {
    static int N, groupCnt;
    static String[] city;
    static ArrayList<Integer> group;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        city = new String[N];
        for (int i = 0; i < city.length; i++) {
            city[i] = br.readLine();
        }
        visit = new boolean[N][N];
    }

    static void dfs(int x, int y) {
        groupCnt++;
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (city[nx].charAt(ny) == '0' || visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && city[i].charAt(j) == '1') {
                    groupCnt = 0;
                    dfs(i, j);
                    group.add(groupCnt);
                }
            }
        }
        Collections.sort(group);
        sb.append(group.size()).append("\n");
        for (int i : group) sb.append(i).append("\n");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
