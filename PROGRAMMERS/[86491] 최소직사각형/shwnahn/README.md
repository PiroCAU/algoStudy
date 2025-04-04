# 사고의 흐름

문제는 가로, 세로 값 바꿔가면서 최소 지갑 크기를 구하기를 원함

### 솔루션 시도 (1)
- 명함 하나씩 추가할 때마다 지갑 적게 커지는 방향으로 고정하기
  - 60x50 다음 30x70이면 30x70, 70x30 둘 다 시도. 
  - 60x70 or 70x50 둘 중 작은 건 후자. 따라서 70x30..
- 이러면 무슨 문제가 생길까?
  - 장기적으로 (모든 수를 고려해서) 판단하지 않음... 근데 구체적으로는 말하기 힘들다.

일단 이렇게 해보자! 

=> 실패함 (fail1)
음... '전역 최적 보장' 방법 서칭 - GPT

### 솔루션 시도 (2)
- 짧은 변은 세로, 긴 변은 가로로 고정
- 가장 긴 변은 무조건 처리해야 하니까 - 가로에 몰아넣기
- 여기에 가장 작은 수를 곱하도록 - 세로에 짧은변 몰아넣기

가로, 세로 각각 최대길이 변 곱하기만 하면됨

=> 성공! (success1)

# 알고리즘
    for (int[] size: sizes){
            // 긴변은 가로, 짧은변은 세로
            int w;
            int h;
            if (size[0] > size[1]) {
                w = size[0];
                h = size[1];
            } else {
                w = size[1];
                h = size[0];
            }
            
            // 가로, 세로 각각 가장 긴 변 찾기
            if (w > max_w){
                max_w = w;
            }
            if (h > max_h){
                max_h = h;
            }
        }
        int answer = max_w * max_h;

# 어려운 점
- 정렬해서 최대값 비교한다는 아이디어 떠올리기가 어려웠다.
- 매번 비교하는 비효율이 어떤 문제가 있을 지 바로 판단이 서지 않음

> NEED MORE PRATCIE!

# 새로 배운 것
- 배열의 크기: array.length
