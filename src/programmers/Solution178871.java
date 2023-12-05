package programmers;


import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/178871
public class Solution178871 {
    // 개별 탐색 시 시간초과
    /*
    public String[] solution(String[] players, String[] callings) {
        for (String call : callings) {
            int index = indexOfPlayer(call, players);
            if (index == 0 || index == -1) continue;
            String temp = players[index - 1];
            players[index - 1] = players[index];
            players[index] = temp;
        }

        return players;
    }

    public int indexOfPlayer(String player, String[] players) {
        for (int i = 0; i < players.length; i++) {
            if (player.equals(players[i]))
                return i;
        }
        return -1;
    }
     */

    // Map으로 index를 관리한다.
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();
        // 각 선수를 키로 index 저장
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        // 각 선수가 불릴때 마다
        for (String call : callings) {
            // 그 선수의 현재 위치
            int back = playerMap.get(call);
            // 그 앞의 선수의 현재 위치
            int front = back - 1;

            // Map을 업데이트 한다.
            playerMap.put(call, front);
            playerMap.put(players[front], back);

            // 배열도 업데이트 한다.
            // Map으로는 내 앞의 선수를 찾기 위해 전체 Value를 순회해야 하기 때문
            String temp = players[front];
            players[front] = players[back];
            players[back] = temp;
        }

        return players;
    }
}
