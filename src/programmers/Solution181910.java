package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181910
public class Solution181910 {
    public String solution(String myString, int n) {
        // substring 메서드를 사용하면 간단히 마무리 된다.
        // return myString
        //        .substring(myString.length() - n);

        // 시작 지점 (뒤에서 n칸)을 지정한다.
        int startIndex = myString.length() - n;
        // 답을 만들기 위한 StringBuilder
        StringBuilder answerBuilder = new StringBuilder();
        // 시작 지점부터 순회 시작
        for (int i = startIndex; i < myString.length(); i++) {
            // 각 자리의 글자를 StringBuilder에 담는다.
            answerBuilder.append(myString.charAt(i));
        }
        // 결과를 반환한다.
        return answerBuilder.toString();
    }
}
