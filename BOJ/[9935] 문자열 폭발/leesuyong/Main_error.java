import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();      // 원본 문자열 (길이 ≤ 1,000,000)
        String bomb = br.readLine();   // 폭발 문자열 (길이 ≤ 36)

        int n = s.length();
        int m = bomb.length();

        while (s.contains(bomb)) {
            s = s.replace(bomb, "");
        }

        if (s.equals("")) {
            System.out.println("FRULA");
        } else {
            System.out.println(s);
        }
    }
}
