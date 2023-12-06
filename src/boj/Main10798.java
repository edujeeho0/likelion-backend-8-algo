package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10798
public class Main10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 다섯줄이 주어지지만, 각 줄의 길이는 주어지지 않는다.
        char[][] letters = new char[5][];
        // 한줄의 최대 길이를 저장해둔다.
        int maxLength = 0;
        for (int i = 0; i < 5; i++) {
            // 각 줄을 받아 letters[i]에 한번에 저장한다.
            letters[i] = reader.readLine().toCharArray();
            // 그 줄의 길이를 최대 길이랑 비교해 최댓값을 저장한다.
            maxLength = Math.max(letters[i].length, maxLength);
        }

        // 출력을 담을 StringBuilder
        StringBuilder answerBuilder = new StringBuilder();
        // 가장 긴 가로줄만큼 순회한다.
        for (int i = 0; i < maxLength; i++) {
            // 다섯줄이기 때문에 다섯번 순회한다.
            for (int j = 0; j < 5; j++) {
                // 만약 j번 줄의 크기가 maxLength에 대돌하지 못한다면,
                // 확인하지 않는다.
                if (!(i < letters[j].length)) continue;
                // 그 외에는 저장
                answerBuilder.append(letters[j][i]);
            }
        }
        // 결과 출력
        System.out.println(answerBuilder);
    }
}
