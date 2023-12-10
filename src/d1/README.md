# 문자열과 배열

[연습문제 링크](practice.md)

## 문자열 다루기

### `String`에서 `char` 추출
[프로그래머스 예시 문제](https://school.programmers.co.kr/learn/courses/30/lessons/181942)
1. `str.toCharArray()`
    ```java
    public class Solution {
    public String solution(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        String answer = "";
        for (int i = 0; i < chars1.length; i++) {
            answer += chars1[i];
            answer += chars2[i];
        }

        return answer;
    }
}
    ```
2. `str.charAt(int i)`
    ```java
    public class Solution {
        public String solution(String str1, String str2) {
            String answer = "";
            for (int i = 0; i < str1.length(); i++) {
                answer += str1.charAt(i);
                answer += str2.charAt(i);
            }
    
            return answer;
        }
    }
    ```

### `StringBuilder`

출력을 직접 하는 문제의 경우, `System.out.println()`을 여러번 사용하는 것보다
`StringBuilder`를 사용해 출력할 내용을 하나의 문자열로 만드는 것이 유리

- 기본 문자열 연결 (`+`)
    ```java
    public class Solution {
        public String solution(String str1, String str2) {
            String answer = "";
            for (int i = 0; i < str1.length(); i++) {
                answer += str1.charAt(i);
                answer += str2.charAt(i);
            }
    
            return answer;
        }
    }
    ```
- `StringBuilder` 사용, `.append()`로 데이터를 문자열에 추가한다.
    ```java
    class Solution {
        public String solution(String str1, String str2) {
            // 문자열을 만들기 위한 StringBuilder
            StringBuilder lineBuilder = new StringBuilder();
            for(int i = 0; i < str1.length(); i++) {
                lineBuilder.append(str1.charAt(i));
                lineBuilder.append(str2.charAt(i));
            }
            return lineBuilder.toString();
        }
    }
    ```

### `BufferedReader`로 입력받기

입력을 받는 경우, `Scanner` 보다 `BufferedReader`가 대부분의 상황에서 더 빠르다.
`readLine()` 메서드로 한줄로 문자열을 입력받고, `.split()`을 이용해 데이터를 사용한다.

단, `IOException`을 메서드에 `throws`로 지정해주어야 한다.

[백준 예시 문제](https://www.acmicpc.net/problem/3003)
```java
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] inPiecesRaw = line.split(" ");
        int[] inPieces = new int[6];
        for(int i = 0; i < 6; i++) {
            String pieceRaw = inPiecesRaw[i];
            inPieces[i] = Integer.parseInt(pieceRaw);
        }
    }
}
```

## 2차원 배열

배열과 같이 선언하되, 대괄호(`[]`)를 두번 사용한다.

```java
public class Main {
    public static void main(String[] args) {
        // 3 * 3의 크기의 행렬
        int[][] matrix = new int[3][3];

        // 1부터 9까지, 각각 행렬에 할당해보자.
        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = num;
                num++;
            }
        }
    }
}
```

또는 데이터를 직접 할당한다.

```java
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }
}
```

### 델타 탐색

2차원 배열의 공간을 탐색하는 문제도 자주 나온다. [예시 문제](https://school.programmers.co.kr/learn/courses/30/lessons/172928).
이런 문제의 경우 방향에 다른 좌표가 변경되는 정도를 저장하기 위한 배열을 따로 선언해 사용하는 경우가 많다. 이를 델타 탐색이라 한다.

```java
int[][] deltas = new int[][]{
        // N
        {-1, 0},
        // S
        {1, 0},
        // W
        {0, -1},
        // E
        {0, 1}
};

for (String route : routes) {
    String[] routeInfo = route.split(" ");
    int distance = Integer.parseInt(routeInfo[1]);
    int dIndex = getDirIndex(routeInfo[0]);
    int[] delta = deltas[dIndex];
    if (!checkBounds(
            answer[0] + delta[0] * distance,
            answer[1] + delta[1] * distance,))
         continue;
    // 생략
}
```

