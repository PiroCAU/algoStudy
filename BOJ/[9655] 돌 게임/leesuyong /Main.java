package BOJ_9655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken());

        boolean flag = N % 2 == 0;
        if (flag) System.out.println("CY");
        else System.out.println("SK");
    }
}
