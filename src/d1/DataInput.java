package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class DataInput {
    // 속도 테스트용 문자열 제작
    public static String makeString(int n) {
        StringBuilder builder = new StringBuilder();
        builder.append("1 ".repeat(n));
        return builder.toString();
    }

    public static void bufferedReader(String line) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(line));;
        String[] tokens = reader.readLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            Integer.parseInt(tokens[i]);
        }
    }

    public static void scannerReader(String line) {
        Scanner scanner = new Scanner(new StringReader(line));
        while (scanner.hasNext()) {
            Integer.parseInt(scanner.next());
        }
    }

    public static void main(String[] args) throws IOException {
        int length = 10000;
        String testString = makeString(length);

        System.out.println("BufferedReader와 Scanner 비교");
        long startTime = System.nanoTime();
        bufferedReader(testString);
        long endTime = System.nanoTime();
        System.out.println("BufferedReader: " + (endTime - startTime));

        startTime = System.nanoTime();
        scannerReader(testString);
        endTime = System.nanoTime();
        System.out.println("Scanner: " + (endTime - startTime));
    }
}
