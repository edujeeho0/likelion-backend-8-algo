package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181904
public class Solution181904 {
    public String solution(String myString, int m, int c) {
        // 정답을 담기 위한 StringBuilder
        StringBuilder answerBuilder = new StringBuilder();
        // 세로로 읽는다고 이야기 하지만, 인덱스 기준으로 생각하면,
        // 한줄에 m개이고, c만큼 더 간 인덱스 들, 즉 나눴을 때 나머지가 c - 1인 인덱스 이다.
        // for의 마지막 조건을 m씩 키우는 방식으로 변경하면 큰 연산 없이 풀이 가능.
        for (int i = c - 1; i < myString.length(); i += m) {
            answerBuilder.append(myString.charAt(i));
        }

        return answerBuilder.toString();
    }
}
