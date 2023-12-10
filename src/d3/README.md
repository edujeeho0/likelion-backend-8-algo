# 스택

[연습문제 링크](practice.md)

- 물건을 쌓아 올리듯 자료를 쌓아 올린 자료구조
- 자료가 일렬로 놓인 선형 자료구조
- 마지막에 들어간 자료가 가장 먼저 나오는 후입선출(Last In First Out) 자료구조

후술할 예시들, 프로그래밍의 함수 호출 및 복귀를 관리하는 Call Stack 등 다양한 방면에서 활용된다.

## Stack 기본기능

- 스택에 데이터를 추가하는 기능 (`push()`)
- 스택에서 데이터를 회수하는 기능 (`pop()`)
- 스택이 비어있는지 확인하는 기능 (`isEmpty()`)
- 스택의 제일 위에 무슨 자료가 있는지 확인하는 기능 (`peek()`)
- (고정된 크기의 배열을 사용하는 경우) 스택이 가득 차 있는지 확인하는 기능 (`isFull()`)

```java
public class MyStack {
    private final int[] arr = new int[10];
    private int top = -1;

    public MyStack() {
    }

    public void push(int x) {
        if (top == arr.length - 1) {
            throw new RuntimeException("stack is full");
        }
        top++;
        arr[top] = x;
        // arr[++top] = x;
    }

    public int pop() {
        if (this.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        int value = arr[top];
        top--;
        return value;
        // return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
    
    public int peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return arr[top];
    }
}
```

## 괄호 검사

주어진 수식 또는 코드의 괄호가 알맞게 작성되었는지 확인하는 문제.
1. 앞에서부터 문자를 하나씩 확인한다.
2. 여는 괄호가 나오면 스택에 `push`
3. 닫는 괄호가 나올 경우
   1. 스택이 비어있으면 잘못된 괄호
   2. 여는 괄호 하나 `pop`
모든 문자를 확인 후 스택이 비어있는지에 따라 괄호가 알맞게 짝지어져 있는지 확인할 수 있다.   

```java
public class ParTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Stack<Character> charStack = new Stack<>();

        // 여기는 어떻게 해도 큰 상관은 없지만 속도가 신경쓰인다면
        for (int i = 0; i < input.length(); i++) {
            // 어쨋든 문자열 문자 하나씩
            char next = input.charAt(i);
            // 여는 괄호일때는 push
            if (next == '(') {
                charStack.push(next);
            }
            // 닫는 괄호일때는
            else if (next == ')'){
                // pop 할게 없으면 틀렸다
                if (charStack.empty()) return false;
                // pop 하자
                char top = charStack.pop();
                // 괄호 맞는지 검사
                if (top != '(') return false;
            }
        }
        // 순회 끝나고 스택이 비어있는지 확인해보자.
        System.out.println(charStack.empty());
    }
}
```

## 깊이 우선 탐색

데이터를 나타내는 여러 정점들로 이뤄진 Graph 자료구조에서, 각 자료를 하나씩 빠짐없이 확인하는 방법 중 하나.
시작점에서 가장 깊이 들어갈 수 있는 점까지 확인한 뒤 다른 점을 탐색한다.

1. 방문한 점에서 도달할 수 있는 점들을 살펴보고, 아직 방문하지 않은 점들의 정보를 스택에 push한다.
2. 스택에서 점의 정보를 pop하여 방문한다. 이후 다시 1번으로 돌아간다.
3. 스택이 빌때까지 반복한다.

```java
package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    // 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxNodes = Integer.parseInt(reader.readLine());
        int[][] adjMap = new int[maxNodes + 1][maxNodes + 1];

        String[] edges = reader.readLine().split(" ");

        // DFS를 할때 연결 정보를 표현하는 방식은 크게 두가지가 있는데, 아래는
        // 2차원 배열을 좌표로 구분하는 방법이다.
        for (int i = 0; i < edges.length / 2; i++) {
            int leftNode = Integer.parseInt(edges[i * 2]);
            int rightNode = Integer.parseInt(edges[i * 2 + 1]);
            adjMap[leftNode][rightNode] = 1;
            adjMap[rightNode][leftNode] = 1;
        }

        Stack<Integer> toVisit = new Stack<>();
        List<Integer> visitedOrder = new ArrayList<>();
        boolean[] visited = new boolean[maxNodes + 1];
        // 첫 방문 대상
        int next = 1;
        // 스택에 넣어둔다.
        toVisit.push(next);
        // 스택이 차있는 동안 반복한다.
        while (!toVisit.empty()) {
            // 다음 방문할 곳을 가져온다.
            next = toVisit.pop();
            // 이미 방문했다면 다음 반복으로
            if (visited[next]) continue;

            // 방문했다 표시
            visited[next] = true;
            // 방문한 순서 기록
            visitedOrder.add(next);

            // 다음 방문 대상을 검색한다.
            // 큰 상관은 없지만, 더 작은 숫자부터 방문하려면 스택에 역순으로 넣는다.
            for (int i = maxNodes; i > 0; i--){
                if (adjMap[next][i] == 1 && !visited[i]) {
                    toVisit.push(i);
                }
            }
        }

        // 출력
        System.out.println(visitedOrder);
    }

    public static void main(String[] args) throws IOException {
        new DepthFirstSearch().solution();
    }

}
```
