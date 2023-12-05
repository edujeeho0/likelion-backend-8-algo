package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10810
public class Main10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] infoString = reader.readLine().split(" ");
        int N = Integer.parseInt(infoString[0]);
        int M = Integer.parseInt(infoString[1]);

        // 바구니 만들기 (기본적으로 0이 된다)
        int[] baskets = new int[N];

        // M 번의 공넣기가 진행된다.
        for (int i = 0; i < M; i++) {
            // 공넣기 정보 해석
            String[] round = reader.readLine().split(" ");
            int start = Integer.parseInt(round[0]);
            int end = Integer.parseInt(round[1]);
            int ball = Integer.parseInt(round[2]);
            // start와 end는 현실에서 세는 식(1부터)이므로, start - 1 부터 end 까지 순회
            for (int j = start - 1; j < end; j++) {
                baskets[j] = ball;
            }
        }

        // 정답 만들기
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answerBuilder.append(baskets[i]);
            answerBuilder.append(" ");
        }
        System.out.println(answerBuilder);
    }
}
