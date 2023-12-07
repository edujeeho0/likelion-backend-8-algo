package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181920
public class Solution181920 {
    public int[] solution(int startNum, int endNum) {
        // 저장해야 하는 숫자의 갯수만큼 배열을 할당한다.
        // 양끝을 포함해야 함으로, endNum - startNum + 1
        int[] answer = new int[endNum - startNum + 1];
        // 숫자들의 갯수만큼 순회하며,
        for (int i = 0; i < answer.length; i++) {
            // 각 순서에 startNum을 더해주면 startNum부터 하나씩 증가한다.
            answer[i] = i + startNum;
        }
        return answer;
    }
}
