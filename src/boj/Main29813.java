package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


// https://www.acmicpc.net/problem/29813
public class Main29813 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));

        // 학생의 숫자 입력
        int studentCount = Integer.parseInt(reader.readLine());
        // 이름과 학번을 저장할 큐 생성
        Queue<String> names = new LinkedList<>();
        Queue<Integer> years = new LinkedList<>();

        // 학생의 수만큼 정보가 들어올테니 그만큼 반복
        for (int i = 0; i < studentCount; i++) {
            // 정보를 공백으로 나누고,
            String[] studentInfo = reader.readLine().split(" ");
            // 이름을 이름 큐에
            names.offer(studentInfo[0]);
            // 학번을 정수로 바꿔서 학번 큐에 넣는다.
            years.offer(Integer.parseInt(studentInfo[1]));
        }

        // 한명이 남을때까지 반복한다.
        while (names.size() > 1 && years.size() > 1) {
            // 제일 앞의 애가 선택할거니, 얘는 주인공의 팀원이 될 수 없다.
            names.poll();
            // 이 학생의 학번을 가져온다.
            int year = years.poll();
            // 학번 - 1 만큼 패스
            for (int i = 0; i < year - 1; i++) {
                names.offer(names.poll());
                years.offer(years.poll());
            }
            // 다음 학생이 앞선 학생의 팀원이다.
            names.poll();
            years.poll();
            // 두 학생 모두 기록할 필요는 없다.
        }

        // 마지막 남은 학생 출력
        System.out.println(names.poll());
    }
}
