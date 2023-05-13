package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_1167 {
    static int n;
    static List<Node>[] tree;
    static boolean[] check;
    static int maxNum = 0;
    static int maxLength = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());

            int num = Integer.parseInt(st.nextToken());
            while (num != -1) {
                int length = Integer.parseInt(st.nextToken());
                tree[index].add(new Node(num, length));

                num = Integer.parseInt(st.nextToken());
            }
        }

        // 임의의 점에서 가장 먼 노드를 구하고, 그 노드에서 가장 먼 노드를 구한다.
        check = new boolean[n + 1];
        dfs(1, 0);
        check = new boolean[n + 1];
        dfs(maxNum, 0);

        System.out.println(maxLength);
    }

    static void dfs(int num, int length) {
        check[num] = true;
        if (length > maxLength) {
            maxNum = num;
            maxLength = length;
        }
        tree[num].forEach(node -> {
            if (!check[node.num]) {
                dfs(node.num, length + node.length);
            }
        });
    }
}

class Node {
    int num;
    int length;

    public Node(int num, int length) {
        this.num = num;
        this.length = length;
    }
}