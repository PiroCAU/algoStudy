package pro.p17683.wldy4627;

public class Main {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;
        m = normalize(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String start = parts[0];
            String end = parts[1];
            String title = parts[2];
            String melody = normalize(parts[3]);

            int playTime = getPlayTime(start, end);
            String fullMelody = buildFullMelody(melody, playTime);

            if (fullMelody.contains(m)) {
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    String normalize(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }

    int getPlayTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        int startMin = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        int endMin = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
        return endMin - startMin;
    }

    String buildFullMelody(String melody, int playTime) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % melody.length()));
        }
        return sb.toString();
    }
}
