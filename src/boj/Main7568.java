package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


// https://www.acmicpc.net/problem/7568
public class Main7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        // 각 사람의 무게 및 키 정보를 받아두기 위한 리스트.
        List<int[]> people = new ArrayList<>(n);
        // 정보를 저장한다.
        for (int i = 0; i < n; i++) {
            String[] personInfo = reader.readLine().split(" ");
            people.add(new int[]{
                    Integer.parseInt(personInfo[0]),
                    Integer.parseInt(personInfo[1])
            });
        }
        // i 보다 덩치가 큰 사람의 수를 over[i]에 저장한다.
        int[] over = new int[n];
        // 두사람씩 비교하는 조합 문제이다.
        // i는 0 ~ n - 2 까지
        for (int i = 0; i < n - 1; i++) {
            // j는 0 ~ n -1 까지
            for (int j = i + 1; j < n; j++) {
                // i번, j번 사람을 가져온다.
                int[] personA = people.get(i);
                int[] personB = people.get(j);
                // i의 키와 몸무게 둘다 j보다 크다.
                if (personA[0] > personB[0] && personA[1] > personB[1])
                    over[j]++;
                // j의 키와 몸무게 둘다 i보다 크다.
                else if (personA[0] < personB[0] && personA[1] < personB[1])
                    over[i]++;
                // 그 외에는 동률이다. (둘중 하나만 일치하는 경우는 문제에서 정의 안했다.)
            }
        }

        // 답변 출력을 준비하자.
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answerBuilder.append(over[i] + 1);
            answerBuilder.append(" ");
        }
        System.out.println(answerBuilder);
    }
}
