package pro.p64064.wldy4627;

import java.util.*;

public class Main {
    static List<List<String>> matchedCandidates;
    static Set<Set<String>> result;

    public int solution(String[] user_id, String[] banned_id) {
        matchedCandidates = new ArrayList<>();

        for (int i = 0; i < banned_id.length; i++) {
            matchedCandidates.add(new ArrayList<>());
            for (String user : user_id) {
                if (isMatch(user, banned_id[i])) {
                    matchedCandidates.get(i).add(user);
                }
            }
        }

        result = new HashSet<>();
        dfs(0, new HashSet<>(), banned_id.length);

        return result.size();
    }

    public static boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }

        return true;
    }

    public static void dfs(int index, Set<String> path, int length) {
        if (index == length) {
            result.add(new HashSet<>(path));
            return;
        }

        for (String candidate : matchedCandidates.get(index)) {
            if(!path.contains(candidate)) {
                path.add(candidate);
                dfs(index + 1, path, length);
                path.remove(candidate);
            }
        }
    }
}
