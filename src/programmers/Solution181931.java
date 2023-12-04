package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181931
public class Solution181931 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        // included 만큼 증가시키며,
        for(int i = 0; i < included.length; i++) {
            // 만일 포함되는 항이라면 더하고,
            if(included[i]) answer += a;
            // 등차수열은 다음 숫자로
            a = a + d;
        }
        return answer;
    }
}
