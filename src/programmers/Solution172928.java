package programmers;

public class Solution172928 {
    public int[] solution(String[] parkStr, String[] routes) {
        // 넓이와 높이 구하기
        int width = parkStr[0].length();
        int height = parkStr.length;

        // char[][]로 변경하기
        char[][] park = new char[parkStr.length][];
        // 공원의 각 열을 순회하며 park에 할당하기
        for (int i = 0; i <parkStr.length; i++) {
            park[i] = parkStr[i].toCharArray();
        }

        // 시작지점 찾기
        // char[i][j] == 'S'인 곳이 시작지점
        // answer[0] = i, answer[1] = j
        int[] answer = new int[2];
        for (int i = 0; i < height; i++) {
            boolean found = false;
            for (int j = 0; j < width; j++) {
                if (park[i][j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        // 1. 델타 탐색 없이 진행
        // 각각의 이동 명령마다 움직인다.
        /*
        for (String route : routes) {
            // 이번 명령 정보 정제
            String[] routeInfo = route.split(" ");
            String direction = routeInfo[0];
            int distance = Integer.parseInt(routeInfo[1]);
            // 방향에 따라 갈수 있는지를 판단한다.
            boolean blocked = false;
            switch (direction) {
                case "E":
                    for (int i = 1; i < distance + 1; i++) {
                        // 동쪽으로 i만큼 가면 넓이를 벗어나나?
                        // 가는길에 장애물이 있느냐?
                        if (answer[1] + i >= width || park[answer[0]][answer[1] + i] == 'X') {
                            blocked = true;
                            break;
                        }
                    }
                    // 막힌적 없으면 (끝까지 갈 수 있으면) 이동
                    if (!blocked) answer[1] += distance;
                    break;
                // 위의 case를 3번 더 (각각 상세한 변경은 따로 해주고)
            }
        }

         */

        // 2. 델타 배열을 만들고 델타 탐색
        int[][] deltas = new int[][] {
                {-1, 0},  // N
                {1, 0},   // S
                {0, -1},  // W
                {0, 1}    // E
        };

        // 각 명령을 순회한다.
        for (String route : routes) {
            String[] routeInfo = route.split(" ");
            String direction = routeInfo[0];
            int distance = Integer.parseInt(routeInfo[1]);
            // 사용할 델타값을 구한다.
            int[] delta;
            switch (direction) {
                case "N":
                    delta = deltas[0];
                    break;
                case "S":
                    delta = deltas[1];
                    break;
                case "W":
                    delta = deltas[2];
                    break;
                case "E":
                    delta = deltas[3];
                    break;
                default:
                    delta = deltas[0];
                    break;
            }

            // 1. 거리만큼 이동하면 범위를 벗어나는지?
            // 0 부터 넓이 사이에 이동할 위치(answer[0] + distance)가 존재하면 범위 내다.
            boolean withinWidth =
                    0 <= answer[1] + distance * delta[1] &&
                    answer[1] + distance * delta[1] < width;
            boolean withinHeight =
                    0 <= answer[0] + distance * delta[0] &&
                    answer[0] + distance * delta[0] < height;
            // 위의 조건이 다 참이어야 이 경로로 이동이 가능하다.
            if (!(withinHeight && withinWidth))
                continue;
            // 2. 가는길에 장애물은 없는지?
            boolean blocked = false;
            // 1 부터 거리까지 순회
            for (int i = 1; i < distance + 1; i++) {
                char now = park[answer[0] + delta[0] * i][answer[1] + delta[1] * i];
                if (now == 'X') {
                    blocked = true;
                    break;
                }
            }
            if (!blocked) {
                answer[0] += delta[0] * distance;
                answer[1] += delta[1] * distance;
            }
        }

        return answer;
    }
}



















