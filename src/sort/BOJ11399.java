package sort;

import java.util.*;
import java.io.*;

public class BOJ11399{
    static int N;
    static int[] times;
    static StringBuilder sb =  new StringBuilder();

    static void process(int[] times) {
        int sum = 0;
        int prev = 0;
        Arrays.sort(times);
        for (int i = 0; i < times.length; i++) {
            sum += prev + times[i];
            prev += times[i];
        }
        sb.append(sum);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < times.length; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        process(times);
        System.out.println(sb.toString());
    }
}