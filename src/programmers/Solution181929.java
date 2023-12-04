package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181929
public class Solution181929 {
    public int solution(int[] numbers) {
        int sum = 0;
        // 합을 구한다.
        for(int num : numbers) {
            sum += num;
        }

        // 곱을 구한다.
        int product = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            product *= numbers[i];
        }
        // 삼항연산자로 1 또는 0 반환
        return product < sum * sum ? 1 : 0;
    }
}
