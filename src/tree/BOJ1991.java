package tree;

import java.util.*;
import java.io.*;

public class BOJ1991 {
    static int N;
    static ArrayList<Integer>[] field;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'A' ;
            for (int j = 0; j < 2; j++) {
                char c = st.nextToken().charAt(0);
                if (c == '.') field[index].add(-1);
                else field[index].add(c - 'A');
            }
        }
    }

    static void preorderTraversal(int x) {
        // root leftChild rightChild
        if (x == -1) return;
        sb.append((char)(x + 'A'));
        preorderTraversal(field[x].get(0));
        preorderTraversal(field[x].get(1));

    }

    static void inorderTraversal(int x) {
        // leftChild root rightChild
        if (x == -1) return;
        inorderTraversal(field[x].get(0));
        sb.append((char)(x + 'A'));
        inorderTraversal(field[x].get(1));
    }

    static void postorderTraversal(int x) {
        // leftChild rightChild root
        if (x == -1) return;
        postorderTraversal(field[x].get(0));
        postorderTraversal(field[x].get(1));
        sb.append((char)(x + 'A'));
    }

    static void pro() {
        preorderTraversal(0);
        sb.append("\n");
        inorderTraversal(0);
        sb.append("\n");
        postorderTraversal(0);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}
