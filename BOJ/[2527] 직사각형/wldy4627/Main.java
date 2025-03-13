package wldy4627;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[4][8];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        sc.close();

        int a1, b1, c1, d1, a2, b2, c2, d2;
        for (int i = 0; i < 4; i++) {
            a1 = arr[i][0];
            b1 = arr[i][1];
            c1 = arr[i][2];
            d1 = arr[i][3];
            a2 = arr[i][4];
            b2 = arr[i][5];
            c2 = arr[i][6];
            d2 = arr[i][7];
            if (c1 < a2 || d2 < b1 || c2 < a1 || d1 < b2) {  // 공통 부분이 없을 때
                System.out.println("d");
            } else if ((c1 == a2 && (d1 == b2 || b1 == d2)) || (a1 == c2 && (b1 == d2 || b2 == d1))){  // 점으로 겹칠 때
                System.out.println("c");
            } else if (b2 == d1 || a2 == c1 || b1 == d2 || a1 == c2) {
                System.out.println("b");  // 선분으로 겹칠 때
            } else {  // 직사각형으로 겹칠 때
                System.out.println("a");
            }
        }
    }
}