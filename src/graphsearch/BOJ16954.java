package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ16954 {
    static String[] field;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {0, 0}};
    static boolean[][] visit;

//    TODO field 파라미터로 전달하기 -> bfs 마다 동적인 그래프 필요
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        field = new String[8];
        for (int i = 0; i < field.length; i++) {
            field[i] = br.readLine();
        }

        visit = new boolean[8][8];
    }

    static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visit[x][y] = true;

    }

    static void pro() {
        bfs(0, 7);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
