package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/14888
public class Main14888 {
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        // 숫자는 n개
        int[] numbers = new int[n];
        String[] numberString = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numberString[i]);
        }
        // 연산자는 4종류
        String[] operatorString = reader.readLine().split(" ");
        int[] operators = new int[]{
                Integer.parseInt(operatorString[0]),
                Integer.parseInt(operatorString[1]),
                Integer.parseInt(operatorString[2]),
                Integer.parseInt(operatorString[3])
        };
        // 순열을 돌린다.
        perm(n, numbers, operators);

        StringBuilder answerBuilder = new StringBuilder();
        answerBuilder.append(max)
                .append('\n')
                .append(min);
        System.out.println(answerBuilder);
    }

    // 순열 도입 메서드
    public static void perm(
            // n개의 숫자와 숫자들, 연산자들
            int n, int[] numbers, int[] operators) {
        permRecursive(n, numbers, operators, new int[n - 1], 0);
    }

    public static void permRecursive(
            int n, int[] numbers, int[] operators,
            // 연산자 조합 저장용 배열
            int[] perm,
            // 현재 연산자를 넣어줄 칸
            int depth
    ) {
        // 숫자의 갯수 - 1이 연산자 선택 횟수이다.
        if (depth == n - 1) {
            // 연산자 조합대로 계산해본다.
            int result = getResult(n, numbers, perm);
            // 최대와 최소 갱신
            max = Math.max(result, max);
            min = Math.min(result, min);
        }
        else {
            // 연산자 4종류 중 하나를 고를 예정인데,
            for (int i = 0; i < 4; i++) {
                // 만약 이미 그 연산자를 다 소진했다면 스킵.
                if (operators[i] == 0) continue;
                operators[i]--;
                perm[depth] = i;
                permRecursive(n, numbers, operators, perm, depth + 1);
                operators[i]++;
            }
        }
    }

    // 주어진 연산자(perm)를 순회하며 그 종류에 따라 계산한다.
    private static int getResult(int n, int[] numbers, int[] perm) {
        // 첫 숫자를 받고,
        int result = numbers[0];
        // 각각 연산자 순회
        for (int i = 0; i < n - 1; i++) {
            // 종류에 따라 적용할 계산이 변동된다.
            switch (perm[i]) {
                case 0:
                    result += numbers[i + 1];
                    break;
                case 1:
                    result -= numbers[i + 1];
                    break;
                case 2:
                    result *= numbers[i + 1];
                    break;
                case 3:
                    result /= numbers[i + 1];
                    break;
            }
        }
        return result;
    }
}
