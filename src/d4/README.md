# 큐

[연습문제 링크](practice.md)

- 대기열 처럼 자료를 세워둔 자료구조
- 자료가 일렬로 놓인 선형 자료구조
- 먼저 들어간 자료가 먼저 나오는 선입선출(First In First Out) 자료구조

## Queue 기본기능

- 큐에 데이터를 추가하는 기능 (`enQueue()`)
- 큐에서 데이터를 꺼내는 기능 (`deQueue()`)
- 큐가 비어있는지 확인하는 기능 (`isEmpty()`)
- 큐의 제일 앞쪽에 무슨 데이터가 있는지 확인하는 기능 (`peek()`)
- (고정된 크기의 배열을 사용하는 경우) 스택이 가득 차 있는지 확인하는 기능 (`isFull()`)

### 선형 Queue

`front`와 `rear`를 이용해 배열의 원소중 다음에 나올 데이터와, 다음에 데이터를 넣을 곳을 가르키는 형태로 만드는 Queue

```java
public class MyQueue {
    private final int[] arr = new int[16];
    private int front = -1;
    private int rear = -1;

    public MyQueue() {}

    public void enQueue(int x) {
        if (rear == arr.length - 1) {
            throw new RuntimeException("queue is full");
        }
        rear++;
        arr[rear] = x;
    }

    public int deQueue() {
        if (front == rear) {
            throw new RuntimeException("queue is empty");
        }
        front++;
        return arr[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return arr[front + 1];
    }
}
```

하지만 `front`는 다시 앞으로 보내지지 않으며, 앞으로 데이터를 보내기 위한 연산 과정이 필요.
완전히 가득차지 않았지만 가득찬것처럼 보일 수 있는 문제가 발생한다.

```java
public boolean isFull() {
    // front 쪽이 비어있다면?
    return rear == arr.length - 1;
}
```

### 원형 Queue

`rear`가 만들어진 배열의 가장 뒤쪽에 위치하게 될 경우, 다음에 데이터를 넣을 때 다시 앞쪽에 데이터를 할당하는 Queue.

선형 Queue에서는 `rear`의 크기를 `rear + 1`로, `front`의 크기를 `front + 1`로 할당하지만,
원형 Queue에서는 `(rear + 1) % size`로, `(front + 1) % size`로 할당한다.

이때, 가득 찬 상태와 비어있는 상태를 구분하기 위해 실제로 필요한 공간은 `size + 1`이 된다.

```java
public class MyCyQueue {
    private final int size = 4;
    private final int offset = size + 1;
    private final int[] arr = new int[offset];
    private int front = 0;
    private int rear = 0;

    public MyCyQueue() {}

    public void enQueue(int x) {
        if (this.isFull()) {
            throw new RuntimeException("queue is full");
        }
        arr[rear] = x;
        rear = (rear + 1) % offset;
    }

    public int deQueue() {
        if (front == rear) {
            throw new RuntimeException("queue is empty");
        }
        int value = arr[front];
        front = (front + 1) % offset;
        return value;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return arr[front + 1];
    }

    public boolean isFull() {
        // front 쪽이 비어있다면?
        return (rear + 1) % offset == front;
    }
}
```

## LinkedList

Java에서 Queue 인터페이스의 구현체로 주로 활용되는 클래스. 연결 리스트의 구조로 만들어져 있다.

- 각 데이터를 `Node`라는 형태로 관리.
- 각 `Node`는 자기 뒤쪽의 `Node`가 어디에 저장되어 있는지에 대한 정보 `link`를 가진다.
- 데이터를 넣을때는 새로운 `Node`를 만들고, 마지막 `Node`의 `link`에 할당.
- 어떤 데이터를 제거할때는 해당 `Node`를 가르키는 `link`에, 제거할 `Node`의 `link`에 담긴 `Node`를 할당.

배열을 사용하는 `ArrayList`에 비해 데이터를 자주 추가 제거할 때 효율성이 더 높다.
단, 중간의 데이터를 조회하는 성능은 `ArrayList`가 더 좋다.

## 너비 우선 탐색

데이터를 나타내는 여러 정점들로 이뤄진 Graph 자료구조에서, 각 자료를 하나씩 빠짐없이 확인하는 방법 중 하나.
어떤 시작 점에서 같은 거리에 있는 점들을 우선적으로 확인한다.

1. 방문한 점에서 도달할 수 있는 점들을 살펴보고, 아직 방문하지 않은 점들을 큐에 `enQueue`한다.
2. 큐에서 점의 정보를 `deQueue`하고 방문한다. 이후 다시 1번으로 돌아간다.
3. 큐가 빌때까지 반복한다.
```java
public class BreadthFirstSearch {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxNodes = Integer.parseInt(reader.readLine());
        int[][] adjMap = new int[maxNodes + 1][maxNodes + 1];

        String[] edges = reader.readLine().split(" ");

        // BFS를 할때 연결 정보를 표현하는 방식은 크게 두가지가 있는데, 아래는
        // 2차원 배열을 좌표로 구분하는 방법이다.
        for (int i = 0; i < edges.length / 2; i++) {
            int leftNode = Integer.parseInt(edges[i * 2]);
            int rightNode = Integer.parseInt(edges[i * 2 + 1]);
            adjMap[leftNode][rightNode] = 1;
            adjMap[rightNode][leftNode] = 1;
        }

        Queue<Integer> toVisit = new LinkedList<>();
        List<Integer> visitedOrder = new ArrayList<>();
        boolean[] visited = new boolean[maxNodes + 1];
        // 첫 방문 대상
        int next = 1;
        // 큐에 넣어둔다.
        toVisit.offer(next);
        // 큐가 차있는 동안 반복한다.
        while (!toVisit.isEmpty()) {
            // 다음 방문할 곳을 가져온다.
            next = toVisit.poll();
            // 이미 방문했다면 다음 반복으로
            if (visited[next]) continue;

            // 방문했다 표시
            visited[next] = true;
            // 방문한 순서 기록
            visitedOrder.add(next);

            // 다음 방문 대상을 검색한다.
            for (int i = 0; i < maxNodes + 1; i++){
                if (adjMap[next][i] == 1 && !visited[i]) {
                    toVisit.offer(i);
                }
            }
        }

        // 출력
        System.out.println(visitedOrder);
    }

    public static void main(String[] args) throws IOException {
        new BreadthFirstSearch().solution();
    }

}
/*
입력 예제:
7
1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7
 */
```
