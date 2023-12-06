package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/3986
public class Main3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        // 좋은 단어가 몇개일까
        int goodWords = 0;
        for (int i = 0; i < N; i++) {
            // 단어를 받는다.
            String word = reader.readLine();
            // 단어가 짝을 잘 맞추는지를 스택으로 확인한다.
            Stack<Character> charStack = new Stack<>();
            // 각 글자를 확인하며,
            for (char c : word.toCharArray()) {
                // 스택이 비어있거나 제일 위의 글자가 현재 글자와 다르면 push
                if (charStack.empty() || charStack.peek() != c) charStack.push(c);
                // 제일 위의 글자가 현재 글자와 같으면 pop
                else if (charStack.peek() == c) charStack.pop();
            }
            // 글자를 다 확인하고 스택이 비어있으면 좋은 단어이다.
            if (charStack.empty()) goodWords++;
        }

        // 갯수 출력
        System.out.println(goodWords);
    }
}
