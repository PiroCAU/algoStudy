import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_error {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();


        Set<Character> set;
        int max = 0;
        int right = 0;

        for (int i = 0; i < str.length(); i++) {
            set = new HashSet<>();
            right = i;

            while (true) {
                //문자열의 끝인경우
                if (right >= str.length()) {
                    break;
                }

                char c = str.charAt(right);

                if (set.contains(c)) {
                    right++;
                } else if (set.size() < n) {
                    right++;
                    set.add(c);
                } else {
                    break;
                }
            }

            int thisResult = right - i;
            max = Math.max(thisResult, max);
        }

        System.out.println(max);
    }
}
