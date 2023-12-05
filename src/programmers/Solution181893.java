package programmers;

import java.util.Arrays;

public class Solution181893 {
    public int[] solution(int[] arr, int[] query) {
        // 범위 설정(왼쪽 이상 오른쪽 미만)
        int leftBound = 0;
        int rightBound = arr.length;
        // 모든 query를 순서에 맞게 가져오기
        for (int i = 0; i < query.length; i++) {
            // 짝수번째 query라면 오른쪽에서 안쪽으로 들어오기
            if (i % 2 == 0) {
                // 결과 배열의 실제 시작지점은 0이 아닌 leftBound 부터다.
                rightBound = leftBound + query[i] + 1;
            }
            // 홀수번째 query라면 왼쪽에서 안쪽으로 들어오기
            else {
                leftBound += query[i];
            }
        }

        return Arrays.copyOfRange(arr, leftBound, rightBound);
    }
}
