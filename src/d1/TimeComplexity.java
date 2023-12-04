package d1;

public class TimeComplexity {
    // 자연수 n을 받아서 (입력 검증 필요 X)
    // 1부터 n까지 모든 자연수를 합하는 메서드
    public static int sumUntilN1(int n) {
        // 모든걸 합한 결과를 담을 변수를 0으로
        int sum = 0;
        // 1부터 n까지 모든 자연수를 확인하며
        for (int i = 1; i < n + 1; i++) {
            // sum에 i를 더한다.
            sum += i;
        }
        // 결과 반환
        return sum;
    }

    // n * (n + 1) / 2를 하면 1부터 n까지의 자연수를
    // 합한것과 동일하다!
    public static int sumUntilN2(int n) {
        // n * (n + 1) / 2를 반환한다.
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(sumUntilN1(10));
        System.out.println(sumUntilN1(100));
        System.out.println(sumUntilN1(1000));
        long endTime = System.nanoTime();
        System.out.println("총 걸린 시간(ns): " + (endTime - startTime));

        startTime = System.nanoTime();
        System.out.println(sumUntilN2(10));
        System.out.println(sumUntilN2(100));
        System.out.println(sumUntilN2(1000));
        endTime = System.nanoTime();
        System.out.println("총 걸린 시간(ns): " + (endTime - startTime));
    }
}
