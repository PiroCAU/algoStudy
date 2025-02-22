import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("HI!");
        // (1) 정보를 입력받는다
        // 첫째 줄 - 세로 크기, 가로 크기 / 둘째 줄 - 종이에 쓰여 있는 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int width = Integer.parseInt(input[0]);
        int height = Integer.parseInt(input[1]);

        // (2) 받은 정보를 데이터에 넣어둔다 > 2차원 배열
        // 2차원 배열 선언
        int[][] grid = new int[height][width];
        for (int i = 0; i < height; i++) {
           // 높이만큼 반복해서 입력받기
           input = br.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                grid[i][j] = Integer.parseInt(input[j]);
            }
        }


/*        // 2차원 배열 출력 확인 (디버깅용)
        System.out.println("입력된 2차원 배열:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }*/

        // (3) 순회 로직을 실시한다.
        // 가장 큰 숫자를 찾는다 -> 어떻게 할까?
        // 근처에 있는 숫자 중 가장 큰 숫자를 찾는다
        // grid 활용 어케하지?

    }
}