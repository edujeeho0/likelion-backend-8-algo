package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main10815 {
    public void solution() throws IOException {
        // 입력 받기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        // Set을 사용하면 구현 자체는 쉽게 마무리할 수 있다.
        String[] myCardString = reader.readLine().split(" ");
        // HashSet & contains
        /*Set<Integer> myCards = new HashSet<>();
        for (int i = 0; i < N; i++) {
            myCards.add(Integer.parseInt(myCardString[i]));
        }

        int M = Integer.parseInt(reader.readLine());
        String[] inCards = reader.readLine().split(" ");
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int result = myCards.contains(Integer.parseInt(inCards[i]))
                    ? 1 : 0;
            answerBuilder.append(result)
                    .append(' ');
        }*/

        // 이진탐색 직접구현
        int[] myCards = new int[N];
        for (int i = 0; i < N; i++) {
            myCards[i] = Integer.parseInt(myCardString[i]);
        }

        Arrays.sort(myCards);

        int M = Integer.parseInt(reader.readLine());
        String[] inCards = reader.readLine().split(" ");
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int result = binarySearch(myCards, Integer.parseInt(inCards[i]))
                    ? 1 : 0;
            answerBuilder.append(result)
                    .append(' ');
        }

        System.out.println(answerBuilder);
    }

    // 이진 탐색
    public boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // 왼쪽 인덱스가 오른쪽 인덱스보다 커지면 발견 실패
        while (left <= right) {
            // 현재 기준에서 절반 지점을 기준으로,
            int mid = left + (right - left) / 2;

            // 가운데에서 발견
            if (arr[mid] == target) {
                return true;
                // 찾는 숫자보다 작다면 지금보다 오른쪽에서 찾는다.
            } else if (arr[mid] < target) {
                left = mid + 1;
                // 찾는 숫자보다 크다면 지금보다 왼쪽에서 찾는다.
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        new Main10815().solution();
    }
}
