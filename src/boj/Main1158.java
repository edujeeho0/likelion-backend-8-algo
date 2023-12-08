package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// https://www.acmicpc.net/problem/1158
public class Main1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int K = Integer.parseInt(info[1]);

        // 정답을 담기위한 리스트
        // 틈새 팁: 내가 담을 원소의 갯수를 미리 알고 있다면,
        // 생성자 사용시 그 값을 전달해서 배열을 미리 키워둘 수 있다.
        List<Integer> result = new ArrayList<>(N);
        // 요세푸스 문제 정의대로 사람을 빼기위한 큐
        Queue<Integer> people = new LinkedList<>();
        // 사람을 넣자, 1 ~ N까지 포함해야 한다.
        for (int i = 1; i < N + 1; i++) {
            // Queue니까 offer를 쓰자
            people.offer(i);
        }

        // 현재 몇번째 사람인지를 기록한 뒤,
        int round = 0;
        // 큐가 빌때까지 반복하며
        while (!people.isEmpty()) {
            int person = people.poll();
            // 이번 사람이 탈락할 차례인지 판단
            if (round == K - 1) {
                // 맞으면 result로
                result.add(person);
                // 초기화
                round = 0;
            }
            else {
                // 아니면 다시 큐로
                people.offer(person);
                round++;
            }
        }

        String resultString = result.toString();
        // 부분 문자열 만들기
        resultString = resultString.substring(1, resultString.length() - 1);
        StringBuilder answerBuilder = new StringBuilder();
        answerBuilder.append('<');
        answerBuilder.append(resultString);
        answerBuilder.append('>');

        System.out.println(answerBuilder);

    }
}

















