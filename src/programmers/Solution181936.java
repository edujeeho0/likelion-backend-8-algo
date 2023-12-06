package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181936
public class Solution181936 {
    public int solution(int number, int n, int m) {
        // number가 n의 배수가 아니라면 0 반환
        if (number % n != 0) return 0;
        // number가 m의 배수가 아니라면 0 반환
        if (number % m != 0) return 0;
        return 1;
    }
}
