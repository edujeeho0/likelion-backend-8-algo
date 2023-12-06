package programmers;


// https://school.programmers.co.kr/learn/courses/30/lessons/181935
public class Solution181935 {
    public int solution(int n) {
        int answer = 0;
        // n이 짝수라면
        if (n % 2 == 0) {
            // i를 0 부터 2씩 증가시킨다.
            for (int i = 0; i < n + 1; i += 2) {
                // i의 제곱을 더한다.
                answer += i * i;
            }
        }
        // n이 홀수라면
        else {
            // i를 1 부터 2씩 증가시킨다.
            for (int i = 1; i < n + 1; i += 2) {
                // i를 더한다.
                answer += i;
            }
        }
        // 결과 반환
        return answer;
    }
}
