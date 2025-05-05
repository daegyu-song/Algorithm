package implementation;

import java.io.*;
import java.util.*;

public class BOJ7568 {

    static int N;
    static int[][] arr;
    static int count = 1;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) count++;
            }
            sb.append(count).append(" ");
            count = 1;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
