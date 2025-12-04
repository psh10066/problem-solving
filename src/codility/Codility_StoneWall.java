package codility;

import java.util.Stack;

public class Codility_StoneWall {

    public int solution(int[] H) {

        Stack<Integer> stack = new Stack<>();

        int count = 0;

        for (int i = 0; i < H.length; i++) {
            int height = H[i];

            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height);
                count++;
            }
        }

        return count;
    }
}
