import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static HashSet<String> notepad;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        notepad = new HashSet<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // N개의 키워드
        for (int i = 0; i < N; i++) {
            notepad.add(br.readLine());
        }

        // M개의 글에 있는 키워드
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ","); // delim: ,

            while (st.hasMoreTokens()) {
                notepad.remove(st.nextToken());
            }

            sb.append(notepad.size()).append('\n');
        }

        System.out.print(sb);
    }
}
/*
 * 메모장에 적힌 키워드: N개
 * 최대 10개의 키워드에 대해 글을 작성
 * 작성된 키워드는 제거
 * 작성 후 남은 키워드 개수
 * 
 * 그냥 hashset으로 넣으면 안되나
 */