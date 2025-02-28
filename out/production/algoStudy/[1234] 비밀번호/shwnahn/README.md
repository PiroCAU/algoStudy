# 핵심 알고리즘

Stack을 활용, 겹치면 pop하는 식으로 구현하였음. 
문제가 복잡해 보였지만, 사실상 겹치는 것을 모두 삭제하기만 하면 되어서 구현이 간단했음.

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

# 어려웠던 점
- 스택의 내용을 문자열로 반환하고, 다시 문자로 반환하는 것
  - StringBuilder를 쓰는 법이 낯설어서 검색으로 해결함.
- 로컬환경에서 테스트 돌릴 때 Scanner 가 직접 엔터 안 넣어주면 안되던데... 웹사이트에서는 잘되더라. 뭐지?
- solution.java 코드에서 T의 존재를 이해하느라 고생함. 내가 조작해서 해결했다.