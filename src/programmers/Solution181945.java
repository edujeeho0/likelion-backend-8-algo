package programmers;

import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/181945
public class Solution181945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력을 받고,
        String str = sc.next();
        // 입력 받은 문자열을 한글자씩 출력해준다.
        for (char a : str.toCharArray()) {
            System.out.println(a);
        }
    }
}
