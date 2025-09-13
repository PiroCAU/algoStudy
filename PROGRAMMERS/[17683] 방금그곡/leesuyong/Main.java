import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // 간단 테스트
        String m = "ABC";
        String[] musicinfos = {
                "12:00,12:14,HELLO,CDEFGAB",
                "13:00,13:05,WORLD,ABCDEF"
        };
        System.out.println(new Solution_17683().solution(m, musicinfos)); // WORLD
    }
}

class Solution_17683 {
    public String solution(String m, String[] musicinfos) {

        String result = "(None)";
        int maxDur = -1;

        m = normalize(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",", 4);
            if (parts.length < 4) continue;

            LocalTime begin = LocalTime.parse(parts[0], DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime end = LocalTime.parse(parts[1], DateTimeFormatter.ofPattern("HH:mm"));
            String name = parts[2];
            String code = parts[3];

            code = normalize(code);

            int duration = (end.toSecondOfDay() - begin.toSecondOfDay()) / 60;
            String playedContent = calContent(code, duration);

            if (playedContent.contains(m)) {
                if (duration > maxDur) {
                    maxDur = duration;
                    result = name;
                }
            }
        }

        return result;

    }

    private String normalize(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }

    private String calContent(String code, int duration) {
        StringBuilder stringBuilder = new StringBuilder(duration);
        for (int i = 0; i < duration; i++) {
            stringBuilder.append(code.charAt(i % code.length()));
        }
        return stringBuilder.toString();
    }
}
