import java.util.*;
import java.io.*;

public class BOJ15650 {
    static int N, M;
    static int[] selected;

    static StringBuilder sb = new StringBuilder();

    static void solution(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(" ");
            sb.append("\n");
        } else {
            for (int i = selected[k - 1] + 1; i <= N; i++) {
                selected[k] = i;
                solution(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];

        solution(1);
        System.out.println(sb.toString());
    }
}
