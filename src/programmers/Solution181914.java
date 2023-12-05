package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181914
public class Solution181914 {
    public int solution(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            // ascii 코드 0 만큼 빼면 해당 정수 값이 된다.
            sum += number.charAt(i) - '0';
        }
        // 모든 수를 더한 값의 9로 나눈 나머지
        return sum % 9;
    }
}
