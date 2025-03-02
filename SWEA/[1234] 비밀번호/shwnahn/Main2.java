import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int testCount = 2;

        // 10개 테스트 케이스 제시됨.
        // 기존: sc.next()로 처리해서 계속 엔터 쳐줘야하는 문제.. sc.nextLine()으로 개선
        for (int i = 0; i < testCount; i++) {
            String line = sc.nextLine();
            String[] lineArr = line.split(" ");
            int testLength = Integer.parseInt(lineArr[0]);
            String testString = lineArr[1];
            String password = makePassword(testLength, testString); // 결과 저장
            String result = "#" + (i + 1) + " " + password;
            System.out.println(result); // 최종 결과 출력
        }
        sc.close();
    }

    public static String makePassword(int length, String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char currentChar = string.charAt(i);
            if (!stack.isEmpty() && stack.peek() == currentChar) {
                stack.pop();
            } else {
                stack.push(currentChar);
            }
        }
        // 스택에 남은 문자들을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString(); // 최종 문자열 반환
    }
}

// Depth 1 같은 숫자 쌍 찾아서 소거
// Depth 2, 3 .... 무한반복

// 중복되고 붙어있는 숫자쌍을 어떻게 찾지? 순회하면서 == 여부 체크
// stirng 순회는 어떻게 하지?
// 무슨 자료형에 정보를 담아서 리턴하지? > 찾아보니 수정은 StringBuilder가 용이.. 복잡하네
// 값을 하나씩 Stack에 쌓고, 겹치면 pop하는 식으로 구현할 수 있지 않을까?


