import java.util.*;
import java.io.*;

public class AS15649 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void solution(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                boolean visit = false;
                for (int j = 1; j < k; j++) {
                    if (arr[j] == i) visit = true;
                }
                if (!visit) {
                    arr[k] = i;
                    solution(k + 1);
                    arr[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];

        solution(1);
        System.out.println(sb.toString());
    }
}
