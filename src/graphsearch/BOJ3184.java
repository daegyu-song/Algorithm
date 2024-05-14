package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ3184 {
    static int R, C, oCnt, vCnt, o, v;
    static boolean[][] visit;
    static String[] field;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        field = new String[R];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            field[i] = st.nextToken();
        }
    }

    static void dfs(int i, int j) {
        visit[i][j] = true;
        if (field[i].charAt(j) == 'o') oCnt++;
        if (field[i].charAt(j) == 'v') vCnt++;

        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];

            if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;
            if (visit[ni][nj]) continue;
            if (field[ni].charAt(nj) == '#') continue;
            dfs(ni, nj);
        }
    }

    static void pro() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visit[i][j] && (field[i].charAt(j) == '.' || field[i].charAt(j) == 'v' || field[i].charAt(j) == 'o')) {
                    dfs(i, j);
                    if (oCnt > vCnt) o += oCnt;
                    else v += vCnt;

                    oCnt = 0;
                    vCnt = 0;
                }
            }

        }
        System.out.println(o + " " + v);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
