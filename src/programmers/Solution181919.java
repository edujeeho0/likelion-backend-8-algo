package programmers;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/181919
public class Solution181919 {
    public int[] solution(int n) {
        // 몇개의 원소가 나올지 모른다. 리스트로 만든다.
        List<Integer> answerList = new ArrayList<>();
        // 현재 숫자가 1이 아닐 동안
        while (n != 1) {
            // 현재 숫자를 넣어주고,
            answerList.add(n);
            // 짝수면 반으로 나누고,
            if (n % 2 == 0) n /= 2;
            // 홀수면 지정된 연산을 진행한다.
            else n = n * 3 + 1;
        }
        // 마지막은 무조건 1이다.
        answerList.add(1);

        // 모은 데이터를 배열로 변환하자.
        // 다른 방법도 있으니 검색해볼것. (Stream이 제일 간편하다.)
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
