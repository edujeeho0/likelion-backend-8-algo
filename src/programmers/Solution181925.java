package programmers;


// https://school.programmers.co.kr/learn/courses/30/lessons/181925
public class Solution181925 {
    public String solution(int[] numLog) {
        StringBuilder answerBuilder = new StringBuilder();
        // 인덱스(순서)가지고 순회를 할것이며,
        // n - 1 까지만 순회하며 앞뒤를 비교
        for (int i = 0; i < numLog.length - 1; i++) {
            int diff = numLog[i + 1] - numLog[i];
            // switch 사용해보자.
            switch (diff) {
                // if(diff == 1)
                case 1:
                    answerBuilder.append('w');
                    break;
                case -1:
                    answerBuilder.append('s');
                    break;
                case 10:
                    answerBuilder.append('d');
                    break;
                case -10:
                    answerBuilder.append('a');
                    break;
            }
        }
        return answerBuilder.toString();
    }
}
