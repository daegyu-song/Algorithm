package implementation;

import java.io.*;
import java.util.*;

public class BOJ10828 {

    static int n;
    static String command;
    static ArrayList<Integer> list;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
    }

    static void pro() throws IOException {
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            switch (command) {
                case "push":
                    list.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if (list.isEmpty()) System.out.println(-1);
                    else System.out.println(list.remove(list.size() - 1));
                    break;

                case "top":
                    if (list.isEmpty()) System.out.println(-1);
                    else System.out.println(list.get(list.size() - 1));
                    break;

                case "size":
                    System.out.println(list.size());
                    break;

                case "empty":
                    if (list.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
