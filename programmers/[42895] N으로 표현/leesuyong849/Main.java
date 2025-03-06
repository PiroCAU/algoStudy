import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        List<Set<Integer>> set = new ArrayList<>();
        for(int i = 0; i <=8; i++) {
            set.add(new HashSet<>());
        }
        
        set.get(1).add(N);
        
        for(int i = 2; i <=8; i++) {
            
            //초기화. 55처럼 단순히 값을 이어붙여서 만드는 숫자들을 넣는다.
            StringBuilder sb = new StringBuilder().append(N);
            for (int j = 1; j < i; j++) {
                sb.append(N);
            }
            set.get(i).add(Integer.parseInt(sb.toString()));
            
            //초기화된 값들을 대상으로 사칙연산을 하는 경우를 계산한다.
            //여기서 사용하는 값들은 둘이 더해서 i가 되는 수들.
            //j부터 1씩 증가시키면서 계산을 한다.
            for (int j = 1; j < i; j++) {
                int n = i - j;
                for (int n1 : set.get(j)) {
                    for (int n2 : set.get(n)) {
                        set.get(i).add(n1 + n2);
                        set.get(i).add(n1 - n2);
                        set.get(i).add(n1 * n2);
                        if (n2 != 0) {
                            set.get(i).add(n1 / n2);
                        }
                    }
                }
            }
            if(set.get(i).contains(number)) {
                return i;
            }
        }
        //없는 경우
        return -1;
    }
}