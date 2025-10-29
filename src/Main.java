import codility.Codility_BinaryGap;
import codility.Codility_CyclicRotation;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Codility_CyclicRotation task1 = new Codility_CyclicRotation();
        test(task1, new int[]{3, 8, 9, 7, 6}, 3);
        test(task1, new int[]{0, 0, 0}, 1);
        test(task1, new int[]{1, 2, 3, 4}, 4);

        System.out.println("==========================");
        System.out.println();

        Codility_BinaryGap task2 = new Codility_BinaryGap();
        test(task2, 152);
        test(task2, 15);
    }









    public static void test(Object task, Object... args) throws InvocationTargetException, IllegalAccessException {
        // 1. 파라미터 출력 (배열 등이 포함될 수 있으므로 deepToString 사용)
        System.out.println("Parameters: " + Arrays.deepToString(args));
        System.out.print("Result:     ");

            // 2. 'solution' 이름을 가진 메서드 찾기
            // (가정: 각 Task 클래스에는 'solution' 메서드가 하나만 존재)
            Method solutionMethod = null;
            for (Method method : task.getClass().getMethods()) {
                if (method.getName().equals("solution")) {
                    solutionMethod = method;
                    break;
                }
            }

            if (solutionMethod == null) {
                System.out.println("ERROR: 'solution' method not found in " + task.getClass().getName());
                System.out.println();
                return;
            }

            // 3. 메서드 동적 실행 (task 객체의 solutionMethod를 args로 호출)
            Object result = solutionMethod.invoke(task, args);

            // 4. 결과값 동적 출력
            printResult(result);

        System.out.println();
    }

    private static void printResult(Object result) {
        if (result == null) {
            System.out.println("null");
            return;
        }

        Class<?> resultClass = result.getClass();

        if (resultClass.isArray()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int length = Array.getLength(result);
            for (int i = 0; i < length; i++) {
                sb.append(Array.get(result, i)); // 각 요소를 동적으로 가져옴
                if (i < length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            System.out.println(sb);
        } else {
            System.out.println(result);
        }
    }
}