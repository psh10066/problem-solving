package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2873 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (r % 2 == 1 || c % 2 == 1) {
            for (int i = 0; i < r; i++) {
                br.readLine();
            }
            if (r % 2 == 1) {
                char LR = 'R';
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c - 1; j++) {
                        sb.append(LR);
                    }
                    if (i < r - 1) {
                        sb.append('D');
                        LR = LR == 'R' ? 'L' : 'R';
                    }
                }
            } else {
                char UD = 'D';
                for (int i = 0; i < c; i++) {
                    for (int j = 0; j < r - 1; j++) {
                        sb.append(UD);
                    }
                    if (i < c - 1) {
                        sb.append('R');
                        UD = UD == 'D' ? 'U' : 'D';
                    }
                }
            }
        } else {
            int minI = Integer.MAX_VALUE;
            int minJ = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if ((i % 2) + (j % 2) == 1 && num < min) {
                        min = num;
                        minI = i;
                        minJ = j;
                    }
                }
            }

            char LR = 'R';
            for (int i = 0; i < r; i += 2) {
                char UD = 'D';
                if (minI == i || minI == i + 1) {
                    for (int j = 0; j < c - 1; j++) {
                        if (j != minJ || (!(UD == 'D' && i + 1 == minI) && !(UD == 'U' && i == minI))) {
                            sb.append(UD);
                            UD = UD == 'D' ? 'U' : 'D';
                        }
                        sb.append(LR);
                    }
                    if (UD == 'D') {
                        sb.append('D');
                    }
                } else {
                    for (int j = 0; j < c - 1; j++) {
                        sb.append(LR);
                    }
                    sb.append('D');
                    LR = LR == 'R' ? 'L' : 'R';
                    for (int j = 0; j < c - 1; j++) {
                        sb.append(LR);
                    }
                }
                if (i < r - 2) {
                    sb.append('D');
                    LR = LR == 'R' ? 'L' : 'R';
                }
            }
        }

        System.out.println(sb);
    }
}