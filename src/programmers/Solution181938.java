package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181938
public class Solution181938 {
    public int solution(int a, int b) {
        String leftResultStr = "" + a + b;
        int rightResult = 2 * a * b;
        int leftResult = Integer.parseInt(leftResultStr);

        return leftResult > rightResult ? leftResult : rightResult;
    }
}
