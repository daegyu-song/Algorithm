package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ16954 {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {0, 0}};
    static String[] field;
    static boolean[][] visit;

    static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);

        while (!queue.isEmpty()) {

            visit = new boolean[8][8];

            int size = queue.size() / 2;
            for (int n = 0; n < size; n++) {
                int i = queue.poll();
                int j = queue.poll();

                if (field[i].charAt(j) == '#') continue;

                if (i == 0 && j == 7) {
                    System.out.println(1);
                    return;
                }

                if (checkStr()) {
                    System.out.println(1);
                    return;
                }

                for (int k = 0; k < dir.length; k++) {
                    int ni = i + dir[k][0];
                    int nj = j + dir[k][1];

                    if (ni < 0 || nj < 0 || ni > 7 || nj > 7) continue;
                    if (field[ni].charAt(nj) == '#') continue;
                    if (visit[ni][nj]) continue;

                    queue.add(ni);
                    queue.add(nj);
                    visit[ni][nj] = true;
                }
            }
            transfer();
        }
        System.out.println(0);
    }

    static boolean checkStr() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (field[i].charAt(j) == '#') return false;
            }
        }
        return true;
    }

    static void transfer() {
        for (int i = 7; i > 0; i--) {
            field[i] = field[i - 1];
        }
        field[0] = "........";
    }

    static void pro() throws IOException {
        bfs(7, 0);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        field = new String[8];
        for (int i = 0; i < field.length; i++) {
            field[i] = br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
