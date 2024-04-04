package sort;

import java.util.*;
import java.io.*;

public class BOJ15970 {
    static int N, answer;
    static Arrow[] arrow;

    static StringBuilder sb = new StringBuilder();

    static class Arrow implements Comparable<Arrow>{
        int num;
        int color;

        public Arrow(int num, int color) {
            this.num = num;
            this.color = color;
        }

        @Override
        public int compareTo(Arrow arrow) {
            return this.num - arrow.num;
        }

    }

    static void process(){
        Arrays.sort(arrow);
        for (int i = 0; i < arrow.length; i++) {
            int check1 = Integer.MAX_VALUE, check2 = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (arrow[j].color == arrow[i].color) {
                    check1 = arrow[i].num - arrow[j].num;
                    break;
                }
            }
            for (int k = i + 1; k <arrow.length; k++) {
                if (arrow[k].color == arrow[i].color) {
                    check2 = arrow[k].num - arrow[i].num;
                    break;
                }
            }
            answer += Math.min(check1, check2);
        }
        sb.append(answer);

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrow = new Arrow[N];
        StringTokenizer st;
        for (int i = 0; i < arrow.length; i++) {
            st = new StringTokenizer(br.readLine());
            arrow[i] = new Arrow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        process();
        System.out.println(sb.toString());
    }
}
