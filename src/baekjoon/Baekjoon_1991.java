package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1991 {

    static char[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new char[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            int index = root - 'A';

            tree[index][0] = root;
            tree[index][1] = st.nextToken().charAt(0);
            tree[index][2] = st.nextToken().charAt(0);
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    static void preOrder(int index) {
        System.out.print(tree[index][0]);
        if (tree[index][1] != '.') preOrder(tree[index][1] - 'A');
        if (tree[index][2] != '.') preOrder(tree[index][2] - 'A');
    }

    static void inOrder(int index) {
        if (tree[index][1] != '.') inOrder(tree[index][1] - 'A');
        System.out.print(tree[index][0]);
        if (tree[index][2] != '.') inOrder(tree[index][2] - 'A');
    }

    static void postOrder(int index) {
        if (tree[index][1] != '.') postOrder(tree[index][1] - 'A');
        if (tree[index][2] != '.') postOrder(tree[index][2] - 'A');
        System.out.print(tree[index][0]);
    }
}