package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
public class Solution161990 {
    // 직접 파일 탐색
    public int[] solution(String[] wallpaper) {
        // 왼쪽 위 좌표
        int lux = 0;
        int luy = 0;
        // 가장 위쪽의 파일이 어딘지를 찾는다.
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                lux = i;
                break;
            }
        }
        // 가장 왼쪽의 파일이 어딘지를 찾는다. i는 왼쪽에서 부터 한칸씩 이동한다.
        for (int i = 0; i < wallpaper[0].length(); i++) {
            // 현재 칸에서 찾았는지 확인
            boolean found = false;
            // 모든 줄을 순회하면서,
            for (String row : wallpaper) {
                // 현재 칸(i)에 파일이 있는지 확인
                if (row.charAt(i) == '#'){
                    luy = i;
                    found = true;
                    break;
                }
            }
            // 발견하면 더 찾을 필요는 없다.
            if (found) break;
        }

        // 오른쪽 아래 좌표
        int rdx = 0;
        int rdy = 0;
        // 가장 아래쪽 파일이 어딘지를 찾는다.
        for (int i = wallpaper.length - 1; i >= 0; i--) {
            if (wallpaper[i].contains("#")) {
                rdx = i;
                break;
            }
        }

        // 가장 오른쪽 파일이 어딘지를 찾는다. i는 오른쪽에서 부터 한칸씩 이동한다.
        for (int i = wallpaper[0].length() - 1; i >= 0; i--) {
            // 현재 칸에서 찾았는지 확인
            boolean found = false;
            // 모든 줄을 순회하면서,
            for (String row : wallpaper) {
                // 현재 칸(i)에 파일이 있는지 확인
                if (row.charAt(i) == '#'){
                    rdy = i;
                    found = true;
                    break;
                }
            }
            // 발견하면 더 찾을 필요는 없다.
            if (found) break;
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }

    // 최대 최소로 찾기
    public int[] solution2(String[] wallpaper) {
        // 왼쪽 위 좌표
        int lux = wallpaper.length;
        int luy = wallpaper[0].length();
        // 오른쪽 아래 좌표
        int rdx = 0;
        int rdy = 0;

        // 전체 칸을 순회한다.
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                // 만약 파일이 있다면,
                if (wallpaper[i].charAt(j) == '#') {
                    // 여태 나온것보다 위에 있었으면 기록
                    lux = Math.min(lux, i);
                    // 여태 나온것보다 왼쪽에 있었으면 기록
                    luy = Math.min(luy, j);
                    // 여태 나온것보다 아래쪽에 있었으면 기록
                    rdx = Math.max(rdx, i);
                    // 여태 나온것보다 오른쪽에 있었으면 기록
                    rdy = Math.max(rdy, j);
                }
            }
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }

    public static void main(String[] args) {
        new Solution161990().solution(new String[]{".#...", "..#..", "...#."});
    }
}
