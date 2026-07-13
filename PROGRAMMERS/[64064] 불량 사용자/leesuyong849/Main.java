package pro.p64064.leesuyong849;

import java.util.ArrayList;
import java.util.HashSet;



public class Main {
}

class Solution {
    String[] userIds;
    String[] bannedIds;
    boolean[] visited;
    HashSet<HashSet<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        visited = new boolean[userIds.length];

    }

    public void dfs(HashSet<String> set, int depth) {
        //벤 아이디에 대해 다 한 번 돌았다
        if (depth == bannedIds.length) {
            result.add(set);
            return;
        }

        for (int i = 0; i < userIds.length; i++) {

        }

    }
}
