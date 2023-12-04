package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181906
public class Solution181906 {
    public int solution(String myString, String isPrefix) {
        // startsWith를 사용하면 바로 답이 나오지만, 사용하지 말아보자.
        // return myString.startsWith(isPrefix) ? 1 : 0;

        // 접두사가 더 길면 말이 안된다.
        if (isPrefix.length() > myString.length())
            return 0;
        // 접두사 길이만큼만 검사한다.
        for (int i = 0; i < isPrefix.length(); i++) {
            // 동일하지 않으면 접두사가 아님 (0)
            if (myString.charAt(i) != isPrefix.charAt(i))
                return 0;
        }
        // 끝까지 반복에 성공하면 접두사 (1)
        return 1;

    }
}
