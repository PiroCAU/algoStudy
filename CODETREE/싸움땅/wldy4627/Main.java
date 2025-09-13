package codetree.wldy4627;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n;
    static PriorityQueue<Integer>[][] map;
    static int[][] playerMap;
    static ArrayList<Player> players = new ArrayList<Player>();
    static int[] points;

    static class Player {
        int x;
        int y;
        int d;
        int s;
        int gun;

        Player(int x, int y, int d, int s, int gun) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
            this.gun = gun;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m, k;
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        map = new PriorityQueue[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = new PriorityQueue<>(Collections.reverseOrder());
                int gunPower = sc.nextInt();
                if (gunPower > 0) {
                    map[i][j].add(gunPower);  // 총이 있을 때만 추가
                }
            }
        }

        playerMap = new int[n + 1][n + 1];
        points = new int[m];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int s = sc.nextInt();
            players.add(new Player(x, y, d, s, 0));
            playerMap[x][y] = i + 1;
        }

        for (int i = 0; i < k; i++) {
            game();
        }

        for (int i = 0; i < points.length; i++) {
            System.out.print(points[i]);
            if (i != points.length - 1) {
                System.out.print(" ");
            }
        }
    }

    static void game() {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);

            // 1. 플레이어가 방향대로 이동
            int nx = player.x + dx[player.d];
            int ny = player.y + dy[player.d];
            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                player.d = (player.d + 2) % 4;
                nx = player.x + dx[player.d];
                ny = player.y + dy[player.d];
            }
            playerMap[player.x][player.y] = 0;

            int targetPlayerIdx = playerMap[nx][ny];
            player.x = nx;
            player.y = ny;

            // 2. 이동한 칸에 플레이어가 없다면
            if (targetPlayerIdx == 0) {
                playerMap[nx][ny] = i + 1;

                // 해당 칸에 총이 있다면
                if (!map[player.x][player.y].isEmpty()) {
                    // 플레이어가 총을 가지고 있지 않았다면 그냥 가져감
                    int floorGun = map[player.x][player.y].peek();

                    // 플레이어가 총을 안 가졌거나, 바닥의 총이 더 강할 경우
                    if (player.gun < floorGun) {
                        // 원래 총을 가지고 있었다면 바닥에 내려놓음
                        if (player.gun > 0) {
                            map[player.x][player.y].add(player.gun);
                        }
                        // 바닥에서 가장 강한 총을 획득
                        player.gun = map[player.x][player.y].poll();
                    }
                }
            } else {  // 3. 이동한 칸에 플레이어가 있다면
                Player opponent = players.get(targetPlayerIdx - 1);
                int playerPower = player.s + player.gun;
                int opponentPower = opponent.s + opponent.gun;

                Player loser, winner;
                int loserIdx, winnerIdx;
                // (초기 능력치 + 총의 공격력)이 더 높은 플레이어가 승리
                // 동일한 경우 초기 능력치가 높은 플레이어가 승리
                // 승리한 플레이어가 그 차이만큼 점수 획득
                if (playerPower > opponentPower || (playerPower == opponentPower && player.s > opponent.s)) {
                    points[i] += playerPower - opponentPower;
                    loser = opponent;
                    winner = player;
                    loserIdx = targetPlayerIdx - 1;
                    winnerIdx = i;
                } else {
                    points[targetPlayerIdx - 1] += opponentPower - playerPower;
                    loser = player;
                    winner = opponent;
                    loserIdx = i;
                    winnerIdx = targetPlayerIdx - 1;
                }
                playerMap[winner.x][winner.y] = winnerIdx + 1;

                // 4. 진 플레이어는 총을 해당 격자에 내려놓고, 원래 방향대로 한 칸 이동함
                if (loser.gun > 0) {
                    map[loser.x][loser.y].add(loser.gun);
                    loser.gun = 0;
                }
                for (int j = 0; j < 4; j++) {
                    int loserNX = loser.x + dx[loser.d];
                    int loserNY = loser.y + dy[loser.d];
                    if (loserNX >= 1 && loserNY >= 1 && loserNX <= n && loserNY <= n && playerMap[loserNX][loserNY] == 0) {
                        loser.x = loserNX;
                        loser.y = loserNY;
                        break;
                    }
                    loser.d = (loser.d + 1) % 4;
                }

                // 만약 총이 있는 경우, 공격력이 가장 높은 총을 획득
                playerMap[loser.x][loser.y] = loserIdx + 1;
                if (!map[loser.x][loser.y].isEmpty()) {
                    loser.gun = map[loser.x][loser.y].poll();
                }

                // 5. 이긴 플레이어는 공격력이 높은 총을 획득하고, 나머지 총은 내려놓음
                if (!map[winner.x][winner.y].isEmpty()) {
                    if (winner.gun < map[winner.x][winner.y].peek()) {
                        if (winner.gun > 0) {
                            map[winner.x][winner.y].add(winner.gun);
                        }
                        winner.gun = map[winner.x][winner.y].poll();
                    }
                }
            }
        }
    }
}
