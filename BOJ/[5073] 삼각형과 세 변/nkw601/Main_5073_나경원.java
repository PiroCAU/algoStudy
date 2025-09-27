import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5073_나경원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int a , b, c;
        while(true){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0) break;

            // 삼각형 안됨
            if(a + b <= c) sb.append("Invalid\n");
            // 삼각형 됨
            else {
                if(a == b && a == c) sb.append("Equilateral\n");
                else if(a == b || a == c || b == c) sb.append("Isosceles\n");
                else sb.append("Scalene\n");
            }
        }

        System.out.println(sb);

    }
}
