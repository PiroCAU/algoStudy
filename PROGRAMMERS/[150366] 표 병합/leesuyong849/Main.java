import java.util.*;

public class Main {

    static String[][] map = new String[51][51];
    static ArrayList<Set<Map<Integer, Integer>>> sets;

    public String[] solution(String[] commands) {
        String[] answer = {};
        ArrayList<String> strs = new ArrayList<>();

        //합병된 셀들의 set
        sets = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            String[] token = commands[i].split(" ");

            if (token[0].equals("UPDATE") && token.length == 4) {
                update1(token);
            } else if (token[1].equals("UPDATE") && token.length == 3) {
                update2(token);
            } else if (token[0].equals("MERGE")) {
                merge(token);
            } else if (token[0].equals("UNMERGE")) {
                unmerge(token);
            }  else if (token[0].equals("PRINT")) {
                strs.add(print(token));
            }
        }
        answer = strs.toArray(new String[0]);
        return answer;
    }

    public int toint(String s) {
        Integer integer = Integer.valueOf(s);
        return integer;
    }

    public void update1(String[] token) {
        map[toint(token[1])][toint(token[2])] = token[3];
    }

    public void update2(String[] token) {
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                if (map[toint(token[i])][toint(token[j])].equals(token[1])) {
                    map[toint(token[i])][toint(token[j])] = token[2];
                }
            }
        }
    }

    public void merge(String[] token) {

        Set<Map<Integer, Integer>> s1 = findSet(toint(token[1]), toint(token[2]));
        Set<Map<Integer, Integer>> s2 = findSet(toint(token[1]), toint(token[2]));
        Map<Integer, Integer> mmm = new HashMap<>(toint(token[1]), toint(token[2]));

    }

    public void unmerge(String[] token) {
        Set<Map<Integer, Integer>> set = findSet(toint(token[1]), toint(token[2]));
        for (Map<Integer, Integer> map : set) {
            for (m)
        }
        sets.remove(set);
    }

    private static Set<Map<Integer, Integer>> findSet(int x, int y) {
        for (Set<Map<Integer, Integer>> set : sets) {
            for (Map<Integer, Integer> map : set) {
                if (map.containsKey(x) && map.get(x).equals(y)) {
                    return set;
                }
            }
        }
        return null;
    }

    public String print(String[] token) {
        return map[toint(token[1])][toint(token[2])];
    }
}
