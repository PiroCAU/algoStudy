package pro.p148653.wldy4627;

class Main {
    public static int solution(int storey) {
        int stone = 0;  // 마법의 돌 개수

        int divider = 1;
        int num;
        while (storey > 0) {
            divider *= 10;

            num = storey % divider;
            if (num < 5 * (divider / 10)) {
                stone += num / (divider / 10);
                storey -= num;
            } else if (num > 5 * (divider / 10)) {
                stone +=  10 - (num / (divider / 10));
                storey += (divider - num);
            } else {
                if (storey % (divider * 10) > 5 * divider) {
                    stone += num / (divider / 10);
                    storey += num;
                } else {
                    stone +=  10 - (num / (divider / 10));
                    storey -= (divider - num);
                }
            }
        }

        return stone;
    }

    public static void main(String[] args) {
        int result = solution(2554);
        System.out.println(result);
    }
}