package codility;

public class Codility_CommonPrimeDivisors {

    public int solution(int[] A, int[] B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int gcd = getGcd(A[i], B[i]);
            if (hasSamePrimeDivisors(A[i], gcd) && hasSamePrimeDivisors(B[i], gcd)) {
                count++;
            }
        }

        return count;
    }

    public int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }

    public boolean hasSamePrimeDivisors(int val, int gcd) {
        if (val == 1) {
            return true;
        }
        int valGcd = getGcd(val, gcd);
        // 둘 사이 최대공약수가 1이면 다른 소수가 있다는 뜻
        if (valGcd == 1) {
            return false;
        }
        return hasSamePrimeDivisors(val / valGcd, gcd);
    }
}
