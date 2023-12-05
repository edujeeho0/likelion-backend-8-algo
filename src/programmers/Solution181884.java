package programmers;


// 기초
// https://school.programmers.co.kr/learn/courses/30/lessons/181884
public class Solution181884 {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        // 주어진 숫자를 차례대로 더한다.
        for (int number : numbers) {
            answer += number;
            // 주어진 n 보다 커지면 반환한다.
            if (answer > n) return answer;
        }
        return answer;
    }
}
