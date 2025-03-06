# 사고의 흐름
### 문제의 요구사항
- 숫자 하나(N)와 타겟 넘버(number)가 제시됨
  - N은 1~9
  - number는 1~32,000
- 괄호, 사칙연산으로 숫자 하나로 타겟넘버 만들기
  - 나머지는 무시
- N 사용횟수 최솟값 리턴
  - 최솟값 8이상이면 -1

### 솔루션 생각하기
숫자별로 드는 최소 계산과정이 있을것...
그걸 반복하면 되지 않을까?
전혀 감이 안 와서 검색을 좀 했다.

>**동적 프로그래밍**

> "N을 1개부터 8개까지 사용해서 만들 수 있는 모든 수를 집합에 저장"

경우의 수를 저장할 때 단계별로 할 수 있을 것.
1. 1개로 만드는 경우: N
2. 2개로 만드는 경우: 1&1 (1의 경우끼리 사칙연산)
3. 3개로 만드는 경우: 1&2
4. 4개: 1&3, 2&2
5. 5개: 1&4, 2&3
6. 6개: 1&5, 2&4, 3&3
7. 7개: 1&6, 2&5, 3&4
8. 8개: 1&7, 2&6, 3&5, 4&4

### **결합값을 빼먹었다...!!!**
5, 55, 555 등...
각각 1, 2, 3 등에 추가해주는 코드 넣어야겠다.

    int a = Integer.parseInt(String.valueOf(N).repeat(index));
    if (N == number) return 1;
    total.add(a);

return 도 빼먹었다가 추가함

# 알고리즘
계산 코드

      public static HashSet<Integer> operate(int n1, int n2) {
      HashSet<Integer> result = new HashSet<>();
      for (int num1 : cases[n1]) {
          for (int num2 : cases[n2]) {
              if(CheckAndAdd(num1 + num2, result)) return result;
              if(CheckAndAdd(num1 - num2, result)) return result;
              if(CheckAndAdd(num2 - num1, result)) return result;
              if(CheckAndAdd(num1 * num2, result)) return result;
              if (num2 != 0 && num1 != 0) {
                  if(CheckAndAdd(num1 / num2, result)) return result;
                  if(CheckAndAdd(num2 / num1, result)) return result;
              }
          }
      }
      return result;

checkAndAdd: .add 대신 넣을때마다 검증

    public static boolean CheckAndAdd(int num, HashSet<Integer> set) {
        if (num == target) {
            foundTarget = true;
            return true;
        }
        set.add(num);
        return false;
    }
# 어려운 점

맨 처음 ideation...
사용개수별로 그룹화할생각 진짜 천재같음

# 새로 배운 것
- HashSet 합치기: addAll 로 한번에 더할 수 있다.