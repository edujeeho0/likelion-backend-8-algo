package programmers;

public class Solution181932 {
    public String solution(String code) {
        StringBuilder answerBuilder = new StringBuilder();
        // 181932 코드 처리하기
        // 기본 모드 설정
        // int mode = 0;
        int mode = '0';
        // code를 앞에서부터 읽자.
        for (int i = 0; i < code.length(); i++) {
            // 현재 문자를 가져오고,
            char letter = code.charAt(i);
            // 현재 문자가 1이면: 모드 변경
            // mode == '1'이면 '1' - mode + '0' == '0'
            // mode == '0'이면 '1' - mode + '0' == '1'
            if (letter == '1') mode = '1' - mode + '0';
            /*{
                if (mode == 0) mode = 1;
                else mode = 0;
            }*/
                // mode가 '1'이면 '1' - '1'은 0, i는 짝수
                // mode가 '0'이면 '1' - '0'은 1, i는 홀수
            else if (i % 2 == '1' - mode) {
                answerBuilder.append(letter);
            }
            // 현재 문자가 1이 아니면
            /*
            else {
                // 모드가 1이고, i가 홀수이면 answerBuilder에 추가
                if (mode == '1' && i % 2 == 1)
                    answerBuilder.append(letter);
                // 모드가 0이고, i가 짝수이면 answerBuilder에 추가
                if (mode == '0' && i % 2 == 0)
                    answerBuilder.append(letter);
            }
             */
        }

        // 결과 수합
        String answer = answerBuilder.toString();
        return answer.isEmpty() ? "EMPTY" : answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution181932().solution("abc1abc1abc"));
    }
}
