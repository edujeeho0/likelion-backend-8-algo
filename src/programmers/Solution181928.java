package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181928
public class Solution181928 {
    public int solution(int[] numbers) {
        // 홀수만 담는 용도의 StringBuilder
        StringBuilder oddNums = new StringBuilder();
        // 짝수만 담는 용도의 StringBuilder
        StringBuilder evenNums = new StringBuilder();
        // 각 숫자를 순회하며
        for (int num : numbers) {
            // 짝수는 짝수 Builder에
            if (num % 2 == 0) evenNums.append(num);
            // 홀수는 홀수 Builder에
            else oddNums.append(num);
        }

        // 각 Builder의 결과를 정수로 변환해 더한다.
        return Integer.parseInt(evenNums.toString()) + Integer.parseInt(oddNums.toString());
    }
}
