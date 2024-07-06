package graphsearch;

import java.io.*;
import java.util.*;

public class BOJ20166 {
    static int N, M, K;
    static String[] field;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    static Map<String, Integer> map = new HashMap<String, Integer>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        field = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            field[i] = st.nextToken();
        }
    }

    static void dfs(int i, int j, String made, int len) {
        if (map.containsKey(made)) map.put(made, map.get(made) + 1);
        else map.put(made, 1);

        if (len == 5) return;

        for (int k = 0; k < dir.length; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];

            if (ni < 0) ni = N - 1;
            if (ni >= N) ni = 0;
            if (nj < 0) nj = M - 1;
            if (nj >= M) nj = 0;

            dfs(ni, nj, made + field[ni].charAt(nj), len + 1);
        }
    }


    static void pro() throws IOException {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, Character.toString(field[i].charAt(j)), 1);
            }
        }

        while (K-- > 0) {
            String check = br.readLine();
            if (map.containsKey(check)) System.out.println(map.get(check));
            else System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
