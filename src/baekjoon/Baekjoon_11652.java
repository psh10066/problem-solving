package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Long key = Long.valueOf(br.readLine());
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }

        Long[] maxKey = new Long[1];
        Integer[] maxValue = new Integer[1];
        hashMap.forEach((key, value) -> {
            if (maxKey[0] == null || maxValue[0] < value || (maxValue[0].equals(value) && maxKey[0] > key)) {
                maxKey[0] = key;
                maxValue[0] = value;
            }
        });

        System.out.println(maxKey[0]);
    }
}