package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/176963
public class Solution176963 {
    public int[] solution(String[] names, int[] yearning, String[][] photos) {
        // 총 사진의 갯수만큼 배열을 할당한다.
        int[] answer = new int[photos.length];
        // Map을 이용해서 각자의 추억 점수를 관리해준다.
        Map<String, Integer> yearnMap = new HashMap<>();
        for (int i = 0; i < names.length; i++){
            // 키는 이름, 값은 점수
            yearnMap.put(names[i], yearning[i]);
        }

        for (int i = 0; i < photos.length; i++) {
            // 각각의 사진이 담고있는 사람들의 목록을 불러온다.
            String[] photo = photos[i];
            // 추억 점수 합을 구하자.
            int sum = 0;
            // 각 사람의 이름을 순회하여
            for (String person : photo) {
                // Map에 존재한다면 그 값을, 아니면 0을 더해준다.
                sum += yearnMap.getOrDefault(person, 0);
            }
            // 이 사진의 추억 점수를 저장해준다.
            answer[i] = sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution176963().solution(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{
                        {"may", "kein", "kain", "radi"},
                        {"may", "kein", "brin", "deny"},
                        {"kon", "kain", "may", "coni"}
                }
        )));
    }
}
