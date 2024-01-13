package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2251 {
    static class Bottle {
        int a, b, c;

        public Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxA = Integer.parseInt(st.nextToken());
        int maxB = Integer.parseInt(st.nextToken());
        int maxC = Integer.parseInt(st.nextToken());

        boolean[][] check = new boolean[maxA + 1][maxB + 1];

        Queue<Bottle> queue = new LinkedList<>();
        queue.add(new Bottle(0, 0, maxC));
        check[0][0] = true;

        Set<Integer> set = new TreeSet<>();
        set.add(maxC);

        while (!queue.isEmpty()) {
            Bottle bottle = queue.poll();

            if (bottle.a > 0) {
                // A -> B
                if (bottle.b < maxB) {
                    int dist = Math.min(bottle.a, maxB - bottle.b);
                    Bottle newBottle = new Bottle(bottle.a - dist, bottle.b + dist, bottle.c);

                    if (!check[newBottle.a][newBottle.b]) {
                        check[newBottle.a][newBottle.b] = true;
                        queue.add(newBottle);

                        if (newBottle.a == 0) {
                            set.add(newBottle.c);
                        }
                    }
                }
                // A -> C
                if (bottle.c < maxC) {
                    int dist = Math.min(bottle.a, maxC - bottle.c);
                    Bottle newBottle = new Bottle(bottle.a - dist, bottle.b, bottle.c + dist);

                    if (!check[newBottle.a][newBottle.b]) {
                        check[newBottle.a][newBottle.b] = true;
                        queue.add(newBottle);

                        if (newBottle.a == 0) {
                            set.add(newBottle.c);
                        }
                    }
                }
            }
            if (bottle.b > 0) {
                // B -> A
                if (bottle.a < maxA) {
                    int dist = Math.min(bottle.b, maxA - bottle.a);
                    Bottle newBottle = new Bottle(bottle.a + dist, bottle.b - dist, bottle.c);

                    if (!check[newBottle.a][newBottle.b]) {
                        check[newBottle.a][newBottle.b] = true;
                        queue.add(newBottle);

                        if (newBottle.a == 0) {
                            set.add(newBottle.c);
                        }
                    }
                }
                // B -> C
                if (bottle.c < maxC) {
                    int dist = Math.min(bottle.b, maxC - bottle.c);
                    Bottle newBottle = new Bottle(bottle.a, bottle.b - dist, bottle.c + dist);

                    if (!check[newBottle.a][newBottle.b]) {
                        check[newBottle.a][newBottle.b] = true;
                        queue.add(newBottle);

                        if (newBottle.a == 0) {
                            set.add(newBottle.c);
                        }
                    }
                }
            }
            if (bottle.c > 0) {
                // C -> A
                if (bottle.a < maxA) {
                    int dist = Math.min(bottle.c, maxA - bottle.a);
                    Bottle newBottle = new Bottle(bottle.a + dist, bottle.b, bottle.c - dist);

                    if (!check[newBottle.a][newBottle.b]) {
                        check[newBottle.a][newBottle.b] = true;
                        queue.add(newBottle);

                        if (newBottle.a == 0) {
                            set.add(newBottle.c);
                        }
                    }
                }
                // C -> B
                if (bottle.b < maxB) {
                    int dist = Math.min(bottle.c, maxB - bottle.b);
                    Bottle newBottle = new Bottle(bottle.a, bottle.b + dist, bottle.c - dist);

                    if (!check[newBottle.a][newBottle.b]) {
                        check[newBottle.a][newBottle.b] = true;
                        queue.add(newBottle);

                        if (newBottle.a == 0) {
                            set.add(newBottle.c);
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : set) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}