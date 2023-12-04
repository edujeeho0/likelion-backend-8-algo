package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// BOJ 문제풀이 템플릿
public class Main3003 {
    public static void main(String[] args) throws IOException {
        // 어떤 입력에 대하여 버퍼링 기능 제공
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));
        // readLine을 통해 한줄 입력 받기
        String input = reader.readLine();

        // 주어진 인자를 (정규 표현식으로 활용해서) 기준으로 삼아
        // 문자열을 나눈 배열로 반환한다.
        String[] splitString = input.split(" ");
//        for (String split : splitString) {
//            System.out.println(split);
//        }

        // 3003 문제 풀어보기

        // 1. 기준이 되는 체스말을 정수 배열로 저장
        int[] rightPieces = {1, 1, 2, 2, 2, 8};

        // 2. 입력받은 각각의 체스말을 살펴본다.
        // 어떤 말인지를 보기 위해 fori 반복을 한다.
        for (int i = 0; i < 6; i++) {
            // 3. 이번 말을 확인한다.
            String pieceRaw = splitString[i];
            // 4. 동일한 말에서, 기준 갯수와 다른 만큼 빼준다.
            // "java string 정수로" 검색
            rightPieces[i] -= Integer.parseInt(pieceRaw);
        }
        // 5. 출력
        System.out.println(String.format(
                "%d %d %d %d %d %d",
                rightPieces[0],
                rightPieces[1],
                rightPieces[2],
                rightPieces[3],
                rightPieces[4],
                rightPieces[5]
        ));
    }
}
