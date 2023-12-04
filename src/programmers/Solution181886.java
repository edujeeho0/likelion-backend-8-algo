package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/181886
public class Solution181886 {
    public String[] solution(String[] names) {
        List<String> answerList = new ArrayList<>();
        // 일반적인 반복문 대신, i를 5씩 증가시킨다.
        for (int i = 0; i < names.length; i += 5) {
            // 해당 위치의 이름만 따로 모은다.
            answerList.add(names[i]);
        }

        // 리스트를 배열로 변환
        return answerList.toArray(new String[0]);
    }

}
