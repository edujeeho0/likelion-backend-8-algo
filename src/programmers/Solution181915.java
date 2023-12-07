package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181915
public class Solution181915 {
    public String solution(String myString, int[] indexList) {
        // 결과를 담을 StringBuilder
        StringBuilder answerBuilder = new StringBuilder();
        // indexList에 담긴 숫자 갯수만큼 반복한다.
        for (int i = 0; i < indexList.length; i++) {
            // 숫자 위치에 있는 문자열을 StringBuilder에 포함시킨다.
            answerBuilder.append(myString.charAt(indexList[i]));
        }

        // 결과를 반환한다.
        return answerBuilder.toString();
    }
}
