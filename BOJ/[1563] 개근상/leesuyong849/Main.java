import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //일수, 지각, 결석
        int[][][] result = new int[1001][2][3];

        result[1][0][0] = 1;
        result[1][1][0] = 1;
        result[1][0][1] = 1;

        for (int i = 2; i <= N; i++) {
            //각 케이스에서 가능한 수들을 구해 더한다.
            result[i][0][0] = (result[i-1][0][0] + result[i-1][0][1] + result[i-1][0][2]) % 1000000;
            result[i][0][1] = result[i-1][0][0] % 1000000;
            result[i][0][2] = result[i-1][0][1] % 1000000;
            result[i][1][0] = (result[i-1][0][0] + result[i-1][0][1] + result[i-1][0][2] + result[i-1][1][0] + result[i-1][1][1] + result[i-1][1][2]) % 1000000;
            result[i][1][1] = result[i-1][1][0] % 1000000;
            result[i][1][2] = result[i-1][1][1] % 1000000;
        }

        System.out.println((result[N][0][0] + result[N][0][1] + result[N][0][2] + result[N][1][0] + result[N][1][2] + result[N][1][2]) % 1000000);
    }
}