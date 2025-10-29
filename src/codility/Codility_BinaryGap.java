package codility;

public class Codility_BinaryGap {
    public int solution(int N) {
        String binaryStr = Integer.toBinaryString(N);
        int maxGap = 0;
        int currentGap = 0;
        boolean counting = false;

        for (char c : binaryStr.toCharArray()) {
            if (c == '1') {
                if (counting) {
                    maxGap = Math.max(maxGap, currentGap);
                }
                counting = true;
                currentGap = 0;
            } else if (counting) {
                currentGap++;
            }
        }

        return maxGap;
    }
}
