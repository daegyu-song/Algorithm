package sort;

import java.util.*;
import java.io.*;

public class BOJ20291 {
    static int N;
    static String[] extensions;

    static StringBuilder sb = new StringBuilder();

    static void process() {
        Arrays.sort(extensions);

        for (int i = 0; i < extensions.length;) {
            int cnt = 1, j = i + 1;
            for (; j < extensions.length; j++) {
                if (extensions[i].compareTo(extensions[j]) == 0) cnt++;
                else break;
            }
            sb.append(extensions[i]).append(" ").append(cnt).append("\n");

            i = j;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        extensions = new String[N];
        StringTokenizer st;
        for (int i = 0; i < extensions.length; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            extensions[i] = st.nextToken();
        }

        process();
        System.out.println(sb.toString());
    }
}
