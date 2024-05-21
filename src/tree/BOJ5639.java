package tree;

import java.util.*;
import java.io.*;

public class BOJ5639 {
    static ArrayList<Integer> field;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        field = new ArrayList<>();

        String input = "";
        while ((input = br.readLine()) != null) {
            field.add(Integer.parseInt(input));
        }
    }

    static void postOrder(int l, int r) {
        if (l > r) return;
        int mid = r;
        for (int i = l + 1; i <= r; i++) {
            if (field.get(i) > field.get(l)) {
                mid = i - 1;
                break;
            }
        }

        postOrder(l + 1, mid);
        postOrder(mid + 1, r);
        sb.append(field.get(l)).append("\n");
    }

    static void pro() {
        postOrder(0, field.size() - 1);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}
