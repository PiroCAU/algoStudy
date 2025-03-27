public class Main {

    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int digit = storey % 10;

            if (digit < 5) {
                // 그냥 내려가는 게 이득
                answer += digit;
            } else if (digit > 5) {
                // 올라갔다가 다음 자리에서 내리는 게 이득
                answer += (10 - digit);
                storey += 10;
            } else {        //만약 제시된 수가 5라면 다음 자리를 확인해야 한다.
                if ((storey / 10) % 10 >= 5) {
                    answer += 5;
                    storey += 10;
                } else {
                    //다음 자리가 5보다 작으면 그냥 내려가는 것이 이득
                    answer += 5;
                }
            }

            storey = storey / 10; //나머지는 자동으로 버린다

        }

        return answer;
    }

}
