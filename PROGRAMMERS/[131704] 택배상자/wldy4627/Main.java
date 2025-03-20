package PROGRAMMERS.p131704.wldy4627;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static public int solution(int[] order) {
        int totalBoxCnt = order.length;
        int truckBoxCnt = 0;  // 영재가 실을 수 있는 상자의 개수

        Stack<Integer> boxStack = new Stack<>();
        for (int i = 0; i < totalBoxCnt; i++) {  // i: 택배의 번호 - 1
            if (order[truckBoxCnt] == i + 1) {
                // 만약 컨테이너 벨트에서 나온 택배를 트럭에 실을 수 있다면
                truckBoxCnt++;
            } else {
                boxStack.push(i + 1);
            }

            // stack에서 꺼내서 택배를 트럭에 실을 수 있는지 확인
            while (!boxStack.isEmpty() && boxStack.peek() == order[truckBoxCnt]) {
                boxStack.pop();
                truckBoxCnt++;
            }
        }
        return truckBoxCnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] tokens = input.split("\\s+");

        int[] order = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            order[i] = Integer.parseInt(tokens[i]);
        }

        int result = solution(order);
        System.out.println(result);
    }
}
