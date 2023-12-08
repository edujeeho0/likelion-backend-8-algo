package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181903
public class Solution181903 {
    public String solution(int q, int r, String code) {
        /*String answer = "";
        // for 반복을 한다.
        for (int i = 0; i < code.length(); i++) {
            if (i % q == r) {
                answer = answer + code.charAt(i);
            }
        }*/
        // 문자열을 동적으로 만들고 싶을 때 사용하는 클래스
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (i % q == r) {
                answerBuilder.append(code.charAt(i));
            }
        }

        return answerBuilder.toString();
    }
}
