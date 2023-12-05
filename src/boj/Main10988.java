package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10988
public class Main10988 {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();

        // 양끝이 일치하는지를 기준으로 한다면 절반만 확인해도 된다.
        for (int i = 0; i < target.length() / 2; i++) {
            // 앞쪽(i)과 뒤쪽(길이 - 1 - i)가 일치하지 않으면 0
            if (target.charAt(i) != target.charAt(target.length() - 1 - i)) {
                System.out.println(0);
                // main의 반환은 큰 의미는 없지만, 프로그램이 종료된다.
                return;
            }
        }

        // 전체 순회에 성공하면 1
        System.out.println(1);
    }
}
