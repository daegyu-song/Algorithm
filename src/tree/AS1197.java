package tree;

import java.io.*;
import java.util.*;

public class AS1197 {

    static int total;
    static int[] parent;
    static Queue<Node> pq = new PriorityQueue<>();

    static class Node implements Comparable<Node>{
        int to;
        int from;
        int value;

        public Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        Arrays.setAll(parent, i -> i);


        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, w));
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int to = find(node.to);
            int from = find(node.from);

            if(!isSameParent(to,from)) {
                total += node.value;
                union(node.to, node.from);
            }
        }

        System.out.println(total);
    }

    public static int find(int i) {
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        return x == y;
    }
}