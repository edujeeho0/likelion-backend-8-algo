package d1;

import java.util.StringTokenizer;

public class StringMethods {
    // 문자열을 char[]로 변환
    // 또는 charAt활용하기
    public static void stringToChar(String source) {
        char[] charArray = source.toCharArray();
        for (int i = 0; i < source.length(); i++) {
            System.out.print(charArray[i]);
            System.out.print(source.charAt(i));
        }
    }

    // 문자열 덧샘 (Concatenation)
    public static String strConcat(int n) {
        String base = "";
        for (int i = 0; i < n; i++) {
            base += "a";
        }
        return base;
    }

    // StringBuilder 활용
    public static String strBuilder(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append("a");
        }
        return builder.toString();
    }

    // string.split()으로 입력 분리
    public static void strSplit(String source) {
        String[] split = source.split(" ");
        for (String str : split) {}
    }

    // StringTokenizer로 개별 토큰 가져오기
    public static void strToken(String source, int n) {
        StringTokenizer tokenizer = new StringTokenizer(source);
        for (int i = 0; i < n; i++) {
            tokenizer.nextToken();
        }
    }

    // 속도 테스트용 문자열 제작
    public static String makeString(int n) {
        StringBuilder builder = new StringBuilder();
        builder.append("1 ".repeat(n));
        return builder.toString();
    }

    public static void main(String[] args) {
        int length = 100000;
        String testString = makeString(length);
        System.out.println("string.split()와 StringTokenizer 비교");
        System.out.println("StringTokenizer는 총 토큰의 갯수를 먼저 안다고 가정한다.");
        long startTime = System.nanoTime();
        strSplit(testString);
        long endTime = System.nanoTime();
        System.out.println("string.split(): " + (endTime - startTime));

        startTime = System.nanoTime();
        strToken(testString, length / 2);
        endTime = System.nanoTime();
        System.out.println("StringTokenizer: " + (endTime - startTime));
        System.out.println();

        // 문자열 덧셈과 StringBuilder 비교
        System.out.println("문자열 덧셈과 StringBuilder 비교");
        startTime = System.nanoTime();
        strConcat(length);
        endTime = System.nanoTime();
        System.out.println("문자열 덧셈: " + (endTime - startTime));

        startTime = System.nanoTime();
        strBuilder(length);
        endTime = System.nanoTime();
        System.out.println("StringBuilder: " + (endTime - startTime));
    }
}
