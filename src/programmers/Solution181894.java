package programmers;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/181894
public class Solution181894 {
    public int[] solution(int[] arr) {
        // 앞쪽 2의 위치 저장용 변수
        int front = -1;
        // 각 원소를 앞에서부터 살펴본다.
        for (int i = 0; i < arr.length; i++) {
            // 2를 찾으면
            if (arr[i] == 2) {
                // 위치를 기록하고
                front = i;
                // 반복을 중단한다.
                break;
            }
        }
        // 만약 2를 찾지 못했다면 front는 여전히 -1일것이다.
        if (front == -1)
            return new int[]{-1};

        int back = 0;
        // 각 원소를 뒤에서부터 살펴본다.
        for (int i = arr.length - 1; i > -1; i--) {
            // 2를 찾으면
            if (arr[i] == 2) {
                // 위치를 기록하고
                back = i;
                // 반복을 중단한다.
                break;
            }
        }

        // 필요한 길이의 배열을 만든다.
        int[] answer = new int[back - front + 1];
        // arr[front] ~ arr[back]까지 answer에 할당한다.
//        for (int i = front; i < back + 1; i++) {
//            answer[i - front] = arr[i];
//        }
//        for (int i = 0; i < back - front + 1; i++) {
//            answer[i] = arr[i + front];
//        }
        answer = Arrays.copyOfRange(arr, front, back + 1);
        return answer;
    }
}
