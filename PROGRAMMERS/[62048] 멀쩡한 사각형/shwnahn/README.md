# 사고의 흐름

### 솔루션
최대한 약분해서 푼다. 그럼 케이스가 둘 중 하나다.
1. 홀수 X 홀수
2. 짝수 X 홀수

(값1) / (값2) 의 올림을 (값2) 에 곱해주면 된다.
1의 경우에는 +1을 해주면 된다.

> 수학적 추론이 틀렸다

# 어려운 점
내 생각과 너무달라잉

# 배운 점
최대공약수 구하기 -> 유클리드 호제법

GCD(270, 192). 270을 192로 나누면 나머지 78

따라서 270 = 192 * 1 + 78. 이 때, GCD(270, 192) = GCD(192, 78)

270과 192의 최대공약수라면 78도 나눠떨어져야해서..
이렇게 상대 숫자에 나누고 나머지에 대해 GCD 하고 반복..

그 결과 GCD(x, 0) 이 나오면 종료. GCD(x, 0) = x

GCD(270,192) = GCD(192, 78) ... = x

### 추가
그리고 생각보다 알고리즘이 단순했다. [블로그 링크](https://velog.io/@eora21/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv2.-%EB%A9%80%EC%A9%A1%ED%95%9C-%EC%82%AC%EA%B0%81%ED%98%95Java-Python) / [유튜브 링크](https://www.youtube.com/watch?v=LZ94TH5L--8)

서로소 사각형에서 버리는 값 구할 때,

끝에서 끝으로 이동한다는 관점으로 본 게 인상적이었다!

# 알고리즘
GCD 알고리즘을 배웠다.

    private int gcd(int big, int small) {
      int remain;
      while (small != 0) {
        remain = big % small;
        big = small;
        small = remain;
      }
      return big;
    }
