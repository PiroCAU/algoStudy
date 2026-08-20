# 프로그래머스 77486 - 다단계 칫솔 판매

## 문제 규칙 요약 (사실 — 출처: [프로그래머스 문제 페이지](https://school.programmers.co.kr/learn/courses/30/lessons/77486))

- 모든 판매원은 판매 이익의 10%를 자신의 추천인에게 배분하고, 나머지 90%는 자신이 갖는다.
- 10%를 계산할 때는 **소수점 이하를 버림(내림)** 처리한다.
- 10%를 계산한 금액이 **1원 미만(=0원)** 이면 분배하지 않고 현재 사람이 전액을 갖는다.
- 추천인이 없는 사람(`referral` 값이 `"-"`)도 예외가 아니다. 다만 그 사람이 위로 올려보내는 10%는 배열에 없는 가상의 "센터"(민호)로 가는 것이라 결과 집계에는 포함되지 않고 그냥 사라진다.
    - 예: john(추천인 없음)이 400원 이익을 냈을 때 → john은 40원을 센터로 보내고 360원만 갖는다. (400원을 다 갖는 게 아님)

## 최종 코드

```java
package BOJ_77486_다단계칫솔;

import java.util.HashMap;

public class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // <자식, 부모>
        HashMap<String, String> parents = new HashMap<>();
        // <이름, enroll에서의 인덱스>
        HashMap<String, Integer> index = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parents.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }

        int[] profit = new int[enroll.length];

        for (int i = 0; i < seller.length; i++) {
            int money = amount[i] * 100;
            String name = seller[i];

            while (true) {
                int fee = money / 10;      // 정수 나눗셈이므로 자동으로 내림 처리됨
                int mine = money - fee;
                profit[index.get(name)] += mine;   // 항상 먼저 현재 사람 몫을 적립

                String parent = parents.get(name);
                if (parent.equals("-") || fee == 0) {
                    break;   // fee는 그냥 버려짐 (센터로 가거나, 나눌 게 없어서 소멸)
                }

                money = fee;
                name = parent;
            }
        }

        return profit;
    }
}
```

## 검증 결과 (사실 — 직접 실행해 확인함)

공식 예제 2개를 이 로직과 동일한 파이썬 코드로 옮겨 실행한 결과, 두 예제 모두 정답과 정확히 일치했다.

| enroll 순서 | 예제1 결과 | 예제2 결과 |
|---|---|---|
| john, mary, edward, sam, emily, jaimie, tod, young | `[360, 958, 108, 0, 450, 18, 180, 1080]` | `[0, 110, 378, 180, 270, 450, 0, 0]` |

- 예제1: `seller=["young","john","tod","emily","mary"]`, `amount=[12,4,2,5,10]`
- 예제2: `seller=["sam","emily","jaimie","edward"]`, `amount=[2,3,5,4]`

두 결과 모두 공식 문제 페이지에 나온 기대값과 동일했다.

## 개발 과정에서 발견된 버그들 (참고용 — 이 대화에서 실제로 논의된 내용)

### 버그 1: `break`를 `profit` 적립 *전에* 실행한 버전
```java
if (parent.equals("-")) {break;}
// 이 아래 profit 적립 코드는 실행되지 않고 지나감
```
- 증상: 최상위 사람(추천인 없음)이 직접 판매한 경우, 또는 체인의 최상단에 도달했을 때 그 사람의 몫이 통째로 0원 처리됨.

### 버그 2: `break` 없이 `profit`에 fee까지 추가로 더해준 버전
```java
if (parent.equals("-") || fee == 0) {
    profit[index.get(name)] += fee;   // 이 줄이 문제
};
// break 없음 → 다음 반복에서 name="-" 상태로 계속 진행됨
```
- 증상 1: `break`가 없어 `name`이 `"-"`가 된 상태로 다음 반복이 실행되고, `index.get("-")`가 `null`을 반환해 **NullPointerException** 발생 가능성이 높음 (실제 채점 환경에서 확인한 것은 아니고, 코드 동작을 시뮬레이션해서 추론한 것임).
- 증상 2: 설령 `break`를 추가하더라도, `parent.equals("-")`인 경우까지 `fee`를 추가로 몰아주는 것은 규칙 위반. 최상위 사람도 10%(fee)는 반드시 떼어 보내야 하며(그 몫이 버려질 뿐), 자기가 가져가면 안 됨. 이 부분은 `fee == 0`인 경우에만 해당하는 규칙을 `parent == "-"`인 경우까지 잘못 확장 적용한 것.

## 핵심 교훈

- "최상위 사람은 100%를 다 가진다"는 규칙은 **존재하지 않음**. 모든 사람은 동일하게 90/10 규칙을 따르며, 다만 최상위 사람이 보내는 10%가 결과 배열에 없는 센터로 가서 안 보일 뿐임.
- 분배를 멈춰야 하는 두 조건(`parent == "-"`, `fee == 0`)은 **"현재 사람 몫을 적립한 뒤" 루프를 끝내는 조건**이지, "추가로 돈을 더 준다"는 조건이 아님.