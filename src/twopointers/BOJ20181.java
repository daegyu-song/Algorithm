package twopointers;

import java.io.*;
import java.util.*;

public class BOJ20181 {

    static class Interval {
        int left;
        long satisfy;
    }

    static int N, K;
    static int[] food;
    static long[] dy;
    static ArrayList<Interval>[] intervals;


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        food = new int[N + 1];
        dy = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            food[i] = Integer.parseInt(st.nextToken());
        }

        intervals = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            intervals[i] = new ArrayList<>();
        }
    }

    static void pro() {
        long sum = 0;

        for (int L = 1, R = 0; L <= N; L++) {

            while (sum < K && R + 1 <= N) sum += food[++R];

            if (sum >= K) {
                Interval i = new Interval();
                i.left = L;
                i.satisfy = sum - K;
                intervals[R].add(i);
            }

            sum -= food[L];
        }

        for (int R = 1; R <= N; R++){
            dy[R] = dy[R - 1];
            for (Interval i : intervals[R]){
                dy[R] = Math.max(dy[R], dy[i.left - 1] + i.satisfy);
            }
        }

        System.out.println(dy[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
