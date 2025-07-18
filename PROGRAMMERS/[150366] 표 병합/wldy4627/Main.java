package pro.p150366.wldy4627;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static int cell[];
    static Map<Integer, String> valueMap = new HashMap<>();

    public String[] solution(String[] commands) {
        cell = new int[2500];
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 2500; i++) {
            cell[i] = i;
        }

        for (int i = 0; i < commands.length; i++) {
            String[] info = commands[i].split(" ");

            if (info[0].equals("UPDATE")) {
                // 1번 경우
                if (info.length == 4) {
                    int id = getId(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                    valueMap.put(findRoot(id), info[3]);
                } else if (info.length == 3) {  // 2번 경우
                    for (Integer key : valueMap.keySet()) {
                        if (valueMap.get(key).equals(info[1])) {
                            valueMap.put(key, info[2]);
                        }
                    }
                }
            } else if (info[0].equals("MERGE")) {
                int id1 = getId(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                int id2 = getId(Integer.parseInt(info[3]), Integer.parseInt(info[4]));
                int root1 = findRoot(id1);
                int root2 = findRoot(id2);

                // 동일한 위치인 경우
                if (root1 == root2) continue;

                String value1 = valueMap.getOrDefault(root1, null);
                String value2 = valueMap.getOrDefault(root2, null);

                valueMap.remove(root1);
                valueMap.remove(root2);

                union(id1, id2);
                int newRoot = findRoot(id1);

                if (value1 != null) {
                    valueMap.put(newRoot, value1);
                } else if (value2 != null) {
                    valueMap.put(newRoot, value2);
                }
            } else if (info[0].equals("UNMERGE")) {
                int id = getId(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                int root = findRoot(id);
                String originalValue = valueMap.getOrDefault(root, null);

                List<Integer> connectedCells = new ArrayList<>();
                for (int j = 0; j < 2500; j++) {
                    if (findRoot(j) == root) {
                        connectedCells.add(j);
                    }
                }

                for (int cellId : connectedCells) {
                    cell[cellId] = cellId;
                }

                valueMap.remove(root);
                if (originalValue != null) {
                    valueMap.put(id, originalValue);
                }
            } else if (info[0].equals("PRINT")) {
                int id = getId(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                String value = valueMap.get(findRoot(id));
                if (value == null) result.add("EMPTY");
                else result.add(value);
            }
        }

        return result.toArray(new String[0]);
    }

    int getId(int r, int c) {
        return (r - 1) * 50 + (c - 1);
    }

    // 대표 루트 찾기
    int findRoot(int x) {
        if (cell[x] != x) {
            cell[x] = findRoot(cell[x]);
        }
        return cell[x];
    }

    void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if (rootA != rootB) {
            cell[rootB] = rootA;
        }
    }
}
