# 사고의 흐름
### 문제 요구사항
- 1~n 택배상자가 있음.
- (1) 상자 내리기
    - 1번부터 순서대로 내리기
- (2) 보조 컨테이너 벨트에 보관하기
    - 후입선출
- (3) 트럭에 싣기
    - 소정의 순서 따를 것

### 생각하기

1~n 상자 내리기

if 트럭 순서에 맞으면 바로 넣기

else 보조 컨테이너 벨트에 보관하기

stack 만들어서 넣고 peek
### 솔루션(1)
트럭에 싣기 알고리즘
1. 보조 컨테이너 맨 위 값 비교
2. 상자 내리고 바로 비교
    - 이거 그냥 보조컨테이너에 넣는다고 생각하면?

둘 다 안되면 싣기 종료

### 솔루션(2)
for 1~n
1. if isCompared = false: Belt -> Truck 루프, isCompared = True
2. 박스 -> Belt, isCompared = False

> isCompared 필요없음 + 1, 2 순서 반대로
# 어려운 점
이 문제는 할만했다.

다만 풀기 전에 알고리즘 순서 고민 많았음.

# 배운 점
나는 while 문을 꽤 더럽게 썼는데,

            while (!belt.isEmpty() && belt.peek() == order[cnt]) {
                belt.pop();
                cnt++;
            }

이렇게도 표현가능하다. 참고해야지

# 알고리즘

        for (int i = 1; i <= order.length; i++) {
            
            // (1) to Belt
            belt.push(i);

            // (2) Belt to Truck 루프
            while (true) {
                if (belt.isEmpty()) {
                    break;
                }
                else if (belt.peek() == order[cnt]) {
                    belt.pop();
                    cnt++;
                } else {
                    break;
                }
            }
        }