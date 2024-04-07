package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1764 {
    static int N, M, Cnt;
    static String[] hear, see;

    static StringBuilder sb = new StringBuilder();

    static void binarySearch(String str) {
        int L = 0;
        int R = see.length - 1;

        while (L <= R) {
            int M = (L + R) / 2;
            if (see[M].compareTo(str) < 0) {
                L = M + 1;
            } else if (see[M].compareTo(str) > 0) {
                R = M - 1;
            } else {
                Cnt++;
                sb.append(str).append("\n");
                break;
            }
        }
    }

    static void process() {
        Arrays.sort(hear);
        Arrays.sort(see);
        for (int i = 0; i < hear.length; i++) {
            binarySearch(hear[i]);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        hear = new String[N];
        M = Integer.parseInt(st.nextToken());
        see = new String[M];
        for (int i = 0; i < hear.length; i++) {
            hear[i] = br.readLine();
        }
        for (int i = 0; i < see.length; i++) {
            see[i] = br.readLine();
        }
        process();
        System.out.println(Cnt);
        System.out.println(sb.toString());
    }
}
