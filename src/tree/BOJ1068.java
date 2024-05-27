package tree;

import java.util.*;
import java.io.*;

public class BOJ1068 {
    static int n, x, root;
    static int[] leaf;
    static ArrayList<Integer>[] field;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        field = new ArrayList[n];
        for (int i = 0; i < n; i++) field[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int par = Integer.parseInt(st.nextToken());
            if (par == -1) {
                root = i;
                continue;
            }
            field[par].add(i);
        }

        leaf = new int[n];
        x = Integer.parseInt(br.readLine());
    }

    static void dfs(int k) {
        if (field[k].isEmpty()) leaf[k] = 1;

        for (int y : field[k]) {
            dfs(y);
            leaf[k] += leaf[y];
        }
    }

    static void pro() {
        for (int i = 0; i < n; i++) {
            if (field[i].contains(x)) {
                field[i].remove(field[i].indexOf(x));
            }
        }

        if (root != x) dfs(root);
        System.out.println(leaf[root]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
