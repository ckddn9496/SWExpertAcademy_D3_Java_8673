# SWExpertAcademy_D3_Java_8673

## SW Expert Academy D4 8673. 코딩 토너먼트 1

### 1. 문제설명

출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW2Jldrqlo4DFASu&categoryId=AW2Jldrqlo4DFASu&categoryType=CODE

input으로 숫자 `N`이 들어오며 다음줄에 이어서 `2^N`개의 숫자가 들어온다. 각 숫자들은 코딩 실력을 뜻하며 `1`번과 `2`번, `3`번과 `4`번, ... , `2k-1`번과 `2k`번 사람이 대결을 하여 코딩실력이 더 높은 사람이 무조건 승리한다. 토너먼트 식으로 승자들은 상위 라운드로 올라가고 같은 방식으로 대결이 이루어진다고 할 때, 지루함이라는 수치는 대결하는 두 선수의 코딩실력의 차로 나타낼 수 있다고 한다. 이때 전체 토너먼트 대결의 지루함 수치를 출력하는 문제 


[입력]

> 첫 번째 줄에 테스트 케이스의 수 `T`가 주어진다.
> 각 테스트 케이스의 첫 번째 줄에는 하나의 정수 `K(1 ≤ K ≤ 10)`이 주어진다.
> 두 번째 줄에는 `2K`개의 정수 `A_1, A_2, … , A_2^K(1 ≤ A_i ≤ 10^5)`이 공백 하나로 구분되어 주어진다.
> `A_i`는 `i`번 사람의 코딩 실력을 나타낸다.


[출력]

> 각 테스트 케이스마다 `#x`(`x`는 테스트케이스 번호를 의미하며 `1`부터 시작한다)를 출력하고,
> 각 테스트 케이스 마다 모든 경기의 지루한 정도의 총합을 출력한다.

### 2. 풀이

인원의 코딩 실력을 담기 위해 `2^N`크기의 배열을 만들어 값을 담는다. `1`라운드에는 `2^(N-1)`번의 대결이 열리며 `k`번째 라운드에는 `2^(N-k)`번의 대결이 열린다는 것으로 반복문을 `N`번 수행하도록 하였다. 공간을 낭비하지 않기 위해 `2k-1`번째사람과 `2k`번째의 사람이 대결을 펼치게되면 지루함수치를 누적해서 더하며 상위 대결로 진출할 승자의 코딩실력을 배열의 `k`번째 인덱스에 저장하여 다음 라운드에 `2k+1`번째사람과 `2k+2`번째 사람중 승자와 대결할수있도록 구현해주었다.

```java

for (int test_case = 1; test_case <= T; test_case++) {
  int N = Integer.parseInt(br.readLine());
  int[] power = new int[(int) Math.pow(2, N)];
  StringTokenizer st = new StringTokenizer(br.readLine());
  for (int i = 0; i < power.length; i++) {
    power[i] = Integer.parseInt(st.nextToken());
  }

  int boring = 0;

  for (int i = N; i > 0; i--) {
    for (int j = 0; j < Math.pow(2, i) / 2; j++) {
      int winner = power[2 * j] > power[2 * j + 1] ? power[2 * j] : power[2 * j + 1];
      boring += Math.abs(power[2 * j] - power[2 * j + 1]);
      power[j] = winner;
    }
  }

  System.out.println("#" + test_case + " " + boring);
}


```
