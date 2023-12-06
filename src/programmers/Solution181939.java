package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181939
public class Solution181939 {
    public int solution(int a, int b) {
        String resultA = "" + a + b;
        // String resultA = String.format("%d%d", a, b);
        // StringBuilder aBuilder = new StringBuilder();
        // aBuilder.append(a).append(b);
        String resultB = "" + b + a;

        int resultAInt = Integer.parseInt(resultA);
        int resultBInt = Integer.parseInt(resultB);

        /*if (resultAInt > resultBInt) {
            return resultAInt;
        }
        else {
            return resultBInt;
        }*/

        return Math.max(resultAInt, resultBInt);
    }

    public static void main(String[] args) {
        new Solution181939().solution(12, 3);
    }
}
