package programmers;

public class Programmers_135807 {
    public int solution(int[] arrayA, int[] arrayB) {
        int first = getGcd(arrayA);
        if (canDivide(first, arrayB)) {
            first = 0;
        }

        int second = getGcd(arrayB);
        if (canDivide(second, arrayA)) {
            second = 0;
        }

        return Math.max(first, second);
    }

    public int getGcd(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = gcd(result, array[i]);
        }
        return result;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public boolean canDivide(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % value == 0) {
                return true;
            }
        }
        return false;
    }
}
