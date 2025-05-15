package pro.p49994.wldy4627;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static String dirs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dirs = sc.nextLine();
        System.out.println(solution(dirs));
    }

    public static int solution(String dirs) {
        HashSet<String> visited = new HashSet<>();

        int currentX = 0;
        int currentY = 0;
        int nextX, nextY;

        for (int i = 0; i < dirs.length(); i++) {
            nextX = currentX;
            nextY = currentY;

            switch (dirs.charAt(i)) {
                case 'U':
                    nextY++;
                    break;
                case 'D':
                    nextY--;
                    break;
                case 'R':
                    nextX++;
                    break;
                default:  // case 'L'
                    nextX--;
                    break;
            }

            if (nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) {
                continue;
            }

            String path = currentX + "" + currentY + "" + nextX + "" + nextY;
            String reversePath = nextX + "" + nextY + "" + currentX + "" + currentY;

            visited.add(path);
            visited.add(reversePath);

            currentX = nextX;
            currentY = nextY;
        }

        return visited.size() / 2;
    }
}
