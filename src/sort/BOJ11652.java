package sort;

import java.io.*;
import java.util.*;


public class BOJ11652 {
    static int N;
    static long[] cards;

    static void process() {
        Arrays.sort(cards);

        long mode = cards[0];
        int modeCnt = 1, curCnt = 1;

        for (int i = 1; i < cards.length; i++) {
            if (cards[i] == cards[i - 1]) {
                curCnt++;
            } else {
                curCnt = 1;
            }
            if (modeCnt < curCnt) {
                mode = cards[i];
                modeCnt = curCnt;
            }
        }

        System.out.println(mode);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new long[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }

        process();
    }
}
