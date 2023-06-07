package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1967 {
    static int n;
    static ArrayList<Node_1967>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            list[n1].add(new Node_1967(n2, length));
            list[n2].add(new Node_1967(n1, length));
        }

        System.out.println(bfs(bfs(1).index).length);
    }

    static Node_1967 bfs(int index) {
        Node_1967 maxNode = new Node_1967(index, 0);

        boolean[] check = new boolean[n + 1];
        Queue<Node_1967> queue = new LinkedList<>();
        queue.add(maxNode);

        while (!queue.isEmpty()) {
            Node_1967 node = queue.poll();
            check[node.index] = true;
            if (maxNode.length < node.length) {
                maxNode = node;
            }

            for (Node_1967 toNode : list[node.index]) {
                if (!check[toNode.index]) {
                    queue.add(new Node_1967(toNode.index, node.length + toNode.length));
                }
            }
        }

        return maxNode;
    }
}

class Node_1967 {
    int index;
    int length;

    public Node_1967(int index, int length) {
        this.index = index;
        this.length = length;
    }
}