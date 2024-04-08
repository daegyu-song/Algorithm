package backtracking;

import java.util.*;
import java.io.*;

public class BOJ1759 {
    static int L, C;
    static String[] alphabet, selected;
    static StringBuilder sb = new StringBuilder();

    static void process(int idx, int depth) {
        if (depth == L) {
            int vowelCnt = 0, consonantCnt = 0;
            for (String s : selected) {
                if (s.equals("a") || s.equals("i") || s.equals("e") || s.equals("o") || s.equals("u")) vowelCnt++;
                else consonantCnt++;
            }
            if (vowelCnt >= 1 && consonantCnt >= 2) {
                for (String s : selected) {
                    sb.append(s);
                }
                sb.append("\n");
            }
        } else {
            for (int i = idx; i < C; i++) {
                selected[depth] = alphabet[i];
                process(i + 1, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabet = new String[C];
        selected = new String[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = st.nextToken();
        }
        Arrays.sort(alphabet);
        process(0, 0);
        System.out.println(sb.toString());
    }
}
