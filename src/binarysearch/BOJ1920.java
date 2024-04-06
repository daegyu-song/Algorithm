package binarysearch;

import java.util.*;
import java.io.*;

public class BOJ1920 {
    static int N, M;
    static int[] arrN, arrM;

    static StringBuilder sb = new StringBuilder();

    static int binarySearch(int x) {
        int L = 0;
        int R = arrN.length - 1;

        while (L <= R) {
            int M = (L + R) / 2;

            if (arrN[M] > x) {
                R = M - 1;
            } else if (arrN[M] < x){
                L = M + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    static void process() {
        Arrays.sort(arrN);

        for (int i = 0; i < arrM.length; i++) {
            sb.append(binarySearch(arrM[i])).append("\n");
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrN.length; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrM.length; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }
        process();
        System.out.println(sb.toString());
    }
}
