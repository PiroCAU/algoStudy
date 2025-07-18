import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == 1) {
                //라이언의 위치가 중요함
                list.add(i);
            }
        }

        //라이언의 크기가 요구되는 최소 양보다 작은 경우 -> 무조건 불가
        if (list.size() < K) {
            System.out.println(-1);
            return;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < list.size() - K + 1; i++) {
            int s = list.get(i);
            int e = list.get(i + K - 1);

            result = Math.min(result, e - s + 1);
        }

        System.out.println(result);
    }
}
