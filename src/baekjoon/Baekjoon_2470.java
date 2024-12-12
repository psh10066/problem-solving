package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2470 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        int v1 = 0;
        int v2 = 0;
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int result = lowerBound(i);

            int sum = Math.abs(arr[i] + arr[result]);
            // -arr[i] 이상 중 가장 작은 수의 index를 구했으므로, 해당 index와 index - 1한 값을 둘 다 비교
            if (sum < closest) {
                closest = sum;
                v1 = i;
                v2 = result;
            }

            if (i < result - 1) {
                sum = Math.abs(arr[i] + arr[result - 1]);
                if (sum < closest) {
                    closest = sum;
                    v1 = i;
                    v2 = result - 1;
                }
            }
        }
        System.out.println(arr[v1] + " " + arr[v2]);
    }

    static int lowerBound(int i) {
        int start = i + 1;
        int end = n - 1;
        // arr[i]과 더했을 때 0과 가장 가까운 값을 찾기 위해 target을 마이너스 값으로 설정하고, target보다 큰 수 중 가장 작은 수의 index를 반환
        int target = -arr[i];

        int index = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                index = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }
}