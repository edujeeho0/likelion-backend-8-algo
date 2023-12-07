package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
각 손님이 주문한 초밥을 확인하는 방법으로는 너무 오래걸린다.
마지막 손님만 주문한 초밥이라면, 손님의 수 만큼 순회.

초밥을 주문한 손님을 기준으로 확인한다면,
1. 초밥을 원하는 손님을 기록한 Queue 찾기
2. 해당 Queue의 가장 앞의 손님을 빼기
의 과정으로 보통 상수 시간으로 해결 가능하다.

또한 입력이 조금 복잡하기 때문에 주의해야 한다.

3 5        // 3: 손님의 수, 5: 나갈 초밥의 수
2 1 6      // 2: 0번 손님의 초밥 주문량, 1 6: 0번 손님이 주문한 초밥(들)
3 2 3 5    // 3: 1번 손님의 초밥 주문량, 2 3 5: 1번 손님이 주문한 초밥(들)
1 1        // 1: 2번 손님의 초밥 주문량, 1: 2번 손님이 주문한 초밥
3 2 1 4 5  // 요리사가 만드는 초밥
 */
// https://www.acmicpc.net/problem/28107
public class Main28107 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 이 코드에서는 받아야 하는 정보가 여러번 등장하는데, 이 변수를 재활용해서 활용한다.
        String[] baseInfo = reader.readLine().split(" ");
        // 손님 수
        int cCount = Integer.parseInt(baseInfo[0]);
        // 초밥을 기다리는 손님을 담기 위한 Map
        Map<Integer, Queue<Integer>> sushiWaiters = new HashMap<>();
        // 서빙될 초밥의 수
        int sCount = Integer.parseInt(baseInfo[1]);

        // 손님의 수만큼 반복한다.
        for (int i = 0; i < cCount; i++) {
            // 정보를 받아 살펴보고,
            baseInfo = reader.readLine().split(" ");
            // 이 손님이 원하는 초밥의 갯수를 받아와
            int waitingCount = Integer.parseInt(baseInfo[0]);
            // 그 크기만큼 순회한다.
            for (int j = 0; j < waitingCount; j++) {
                // 다음 칸부터 초밥의 정보가 나오는데,
                int sushi = Integer.parseInt(baseInfo[j + 1]);
                // 만약 아직 주문된적 없는 초밥이라면
                if (sushiWaiters.get(sushi) == null)
                    // 새로운 Queue를 생성한다.
                    sushiWaiters.put(sushi, new LinkedList<>());
                // 그리고 손님을 초밥 큐에 넣어준다.
                sushiWaiters.get(sushi).add(i);
            }
        }

        // 나올 초밥들을 저장해둔다.
        int[] sushiOut = new int[sCount];
        baseInfo = reader.readLine().split(" ");
        for (int i = 0; i < sCount; i++) {
            sushiOut[i] = Integer.parseInt(baseInfo[i]);
        }

        /*// Stream 사용으로 만들수도 있다.
        int[] sushiOut = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();*/
        // 각 손님이 몇개를 먹었는지 확인하기 위한 배열
        int[] customerAte = new int[cCount];

        // 각 초밥을 확인해보자.
        for (int sushi : sushiOut) {
            // 이 초밥을 원하는 손님들을 담은 큐를 회수한다.
            Queue<Integer> thisWaiter = sushiWaiters.get(sushi);
            // 여기에 큐가 없거나 비어있다면, 이 초밥은 더이상 원하는 사람이 없다는 뜻.
            if (thisWaiter == null || thisWaiter.isEmpty()) continue;
            // 큐의 가장 앞의 손님을 찾는다.
            int waiter = thisWaiter.poll();
            // 그 손님이 먹은 갯수가 하나 증가한다.
            customerAte[waiter]++;
        }

        // 결과 출력
        StringBuilder answerBuilder = new StringBuilder();
        for (int ate: customerAte) {
            answerBuilder.append(ate);
            answerBuilder.append(" ");
        }
        System.out.println(answerBuilder);
    }
}
