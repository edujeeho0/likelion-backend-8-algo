package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181908
public class Solution181908 {
    public int solution(String myString, String isSuffix) {
        // endsWith를 사용하면 바로 답이 나오지만, 사용하지 말아보자.
        // return myString.endsWith(isSuffix) ? 1 : 0;

        // 접미사가 더 길면 말이 안된다.
        if (isSuffix.length() > myString.length())
            return 0;
        // 접미사 길이만큼만 검사한다. 단, 뒤에서 검사한다.
        for (int i = 0; i < isSuffix.length(); i++) {
            // 동일하지 않으면 접미사가 아님 (0)
            if (myString.charAt(myString.length() - i - 1)
                != isSuffix.charAt(isSuffix.length() - i - 1))
                return 0;
        }
        return 1;

    }
}
