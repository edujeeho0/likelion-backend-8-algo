package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/159994
public class Solution159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 현재 몇번째 카드까지 확인했는지를 각자 따로 관리한다.
        int card1Idx = 0;
        int card2Idx = 0;
        // 만들고자 하는 목표 문자열을 goal에서 하나씩 꺼낸다.
        for (String string : goal) {
            // 아직 cards1에 볼 카드가 남았고, 가장 앞의 카드가 찾는 문자열과 일치한다.
            if (card1Idx < cards1.length && cards1[card1Idx].equals(string)) {
                // 다음 문자열에서는 cards1의 다음 카드를 살펴볼것이다.
                card1Idx++;
                // 밑의 코드는 더 실행 안해도 된다.
                continue;
            }
            // 아직 cards2에 볼 카드가 남았고, 가장 앞의 카드가 찾는 문자열과 일치한다.
            if (card2Idx < cards2.length && cards2[card2Idx].equals(string)) {
                // 다음 문자열에서는 cards2의 다음 카드를 살펴볼것이다.
                card2Idx++;
                // 밑의 코드는 더 실행 안해도 된다.
                continue;
            }
            // 만약 위 두 if가 성립하지 않았다면, 필요한 카드가 없는 것이므로 실패한다.
            return "No";
        }
        // 모든 문자열을 순회에 성공했다면 성공이다.
        return "Yes";
    }
}
