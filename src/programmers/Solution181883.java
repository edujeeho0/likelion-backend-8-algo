package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181883
class Solution181883 {
    public int[] solution(int[] arr, int[][] queries) {
        // 각 query를 확인
        for (int[] query : queries) {
            // query의 시작점 끝점
            int start = query[0];
            int end = query[1];
            // 해당 구간을 전부 증가시킨다.
            for (int j = start; j < end + 1; j++) {
                arr[j]++;
            }
        }
        return arr;
    }
}
