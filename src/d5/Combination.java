package d5;

import java.util.Arrays;

public class Combination {
    // n개 중에서 3개를 선택하는 방법들을 출력하는 메서드
    // nC3을 출력하는 메서드
    public static void combSimple(int n) {
        int first;
        int second;
        int third;
        // i는 0 부터 n - 2까지 반복하고,
        for (int i = 0; i < n - 2; i++) {
            first = i;
            // j는 i + 1 부터 n - 1까지 반복하고,
            for (int j = first + 1; j < n - 1; j++) {
                second = j;
                // k는 j + 1 부터 n까지 반복한다.
                for (int k = second + 1; k < n; k++) {
                    third = k;
                    System.out.println(first + " " + second + " " + third);
                }
            }
        }
    }

    // 재귀함수로 nCr 구하는 메서드
    public static void combRecurHelper(
            // 몇개(n)중에서 몇개(r)을 고를지
            int n, int r,
            // 여태까지 몇개의 원소를 골랐는지
            int count,
            // 이번에 고를지 말지를 판단중인 숫자
            int next,
            // 조합 결과를 담을 배열
            int[] comb
    ) {
        // r개 골라야 하는데 다 골랐다.
        if (count == r) {
            System.out.println(Arrays.toString(comb));
        }
        // 만약, 내가 고르려고 고려할 애가 범위를 벗어날려 한다면
        else if (next == n) {
            return;
        }
        else {
            // 만약 내가 이번에 next를 골랐다.
            comb[count] = next;
            // count 번째 원소를 골랐으니, count + 1 번째 원소를 고르러 가자.
            combRecurHelper(n, r, count + 1, next + 1, comb);

            // count 번째 원소를 고르지 않고, 다음 원소를 확인하자.
            combRecurHelper(n, r, count, next + 1, comb);
        }
    }

    public static void combRecur(int n, int r) {
        combRecurHelper(n, r, 0, 0, new int[r]);
    }

    public static void main(String[] args) {
        combSimple(5);
        combRecur(5, 3);
    }

}
