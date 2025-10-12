import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true){
            String s = br.readLine();
            s = s.toLowerCase();
            if(s.equals("end")) break;

            boolean flag = false;
            int vCnt = 0;
            int cCnt = 0;
            for(int i = 0; i < s.length(); i++){
                char cur = s.charAt(i);
                if(i > 0){
                    char prev = s.charAt(i - 1);
                    if (cur == prev && cur != 'e' && cur != 'o') {
                        flag = false;
                        break;
                    }
                }
                if(isVowel(cur)){
                    flag = true;
                    vCnt++;
                    cCnt = 0;
                    if (vCnt >= 3) {
                        flag = false;
                        break;
                    }
                } else {
                    cCnt++;
                    vCnt = 0;
                    if (cCnt >= 3) {
                        flag = false;
                        break;
                    }
                }
            }


            if(flag){
                sb.append("<").append(s).append("> is acceptable.\n");
            } else {
                sb.append("<").append(s).append("> is not acceptable.\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}
// 모음 하나 포함
// 모음, 자음 연속 3 X
// ee, oo 제외 같은 글자 연속 X