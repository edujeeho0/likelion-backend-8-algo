package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// https://www.acmicpc.net/problem/19532
public class Main19532 {
    public String solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int d = Integer.parseInt(input[3]);
        int e = Integer.parseInt(input[4]);
        int f = Integer.parseInt(input[5]);

        // 얼핏 연립방정식을 풀고 싶어질 수 있지만, 숫자가 몇개 되지 않는다.
        // 1999가지 숫자중 중복을 허용하여 2개 선택한다.
        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                // 요구하는 연립방정식이 맞는지를 확인한다.
                if (a * i + b * j == c && d * i + e * j == f)
                    return i + " " + j;
            }
        }
        return "0 0";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Main19532().solution());
    }
}
