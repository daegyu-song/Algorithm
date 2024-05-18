package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ3055 {
    static int R, C;
    static String[] field;
    static int[][] dist;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        field = new String[R];
        for (int i = 0; i < R; i++) {
            field[i] = br.readLine();
        }

        dist = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dist[i][j] = -1;
            }
        }
    }

    static void bfs() {
        // S, * x n 을 MultiSource BFS 에 저장 - 순서 유의
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (field[i].charAt(j) == '*') {
                    que.add(i);
                    que.add(j);
                    dist[i][j] = -2;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (field[i].charAt(j) == 'S') {
                    que.add(i);
                    que.add(j);
                    dist[i][j] = 0;
                }
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll(), y = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (dist[nx][ny] != -1) continue;
                if (field[nx].charAt(ny) == 'X') continue;
                if (dist[x][y] == -2 && field[nx].charAt(ny) == 'D') continue;

                que.add(nx);
                que.add(ny);
                if (dist[x][y] == -2) dist[nx][ny] = -2;
                else {
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }

    }

    static void pro() {
        bfs();

        // D 위치의 dist
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (field[i].charAt(j) == 'D') System.out.println(dist[i][j] == -1 ? "KAKTUS" : dist[i][j]);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
