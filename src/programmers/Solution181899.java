package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181899
public class Solution181899 {
    public int[] solution(int start, int end) {
        // 양끝 숫자를 포함할 수 있는 만큼 길이를 할당한다.
        int[] answer = new int[start - end + 1];
        for (int i = 0; i < answer.length; i++) {
            // 지금 순서만큼 첫 숫자에서 뺀다.
            answer[i] = start - i;
        }
        return answer;
    }
}
