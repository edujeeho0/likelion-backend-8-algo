package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10809
public class Main10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();
        // 소문자 알파벳 갯수만큼의 배열 생성
        int[] array = new int[26];
        // 배열 내부를 -1로 채워넣기
        Arrays.fill(array, -1);
        for (int i = 0; i < target.length(); i++) {
            // 'a'의 값만큼 빼주면 해당 알파벳에 해당하는 index를 구할 수 있다.
            int index = target.charAt(i) - 'a';
            // 등장한 적 없다면, 값을 갱신해준다.
            if (array[index] == -1)
                array[index] = i;
        }

        // 출력 형태 조정
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            answerBuilder.append(array[i]);
            answerBuilder.append(" ");
        }

        System.out.println(answerBuilder);
    }
}
