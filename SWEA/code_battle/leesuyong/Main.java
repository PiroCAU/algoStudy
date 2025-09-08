import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CODE_battle {

    public static int N; // 격자 크기 (N x N)
    public static int M; // 플레이어 수
    public static int K; // 라운드 수

    public static ArrayList<Integer>[][] grid; // 각 칸의 총 목록
    public static ArrayList<Player> players = new ArrayList<>();

    public static final int[] dx = {-1, 0, 1, 0};
    public static final int[] dy = {0, 1, 0, -1};

    static class Player {
        int x, y, dir;
        int weapon = 0;
        int ability;
        int point = 0;

        Player(int x, int y, int dir, int ability) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.ability = ability;
        }

        void changeDir(int a) {
            dir = (dir + a) % 4;
        }

        void move() {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                changeDir(2);
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx; y = ny;
        }

        int power() {
            return ability + weapon;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int g = Integer.parseInt(st.nextToken());
                if (g > 0) grid[i][j].add(g);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            players.add(new Player(x, y, d, s));
        }

        // 진행
        for (int r = 0; r < K; r++) {
            for (int pIndex = 0; pIndex < M; pIndex++) {
                Player p = players.get(pIndex);

                p.move();

                // 해당 칸에 다른 플레이어가 있는지 확인
                int enemyIdx = findPlayerOn(p.x, p.y, pIndex);

                if (enemyIdx == -1) {
                    //전투 없으면: 총 줍기
                    pickBestGun(p.x, p.y, p);
                } else {
                    //전투
                    fight(p, players.get(enemyIdx));
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Player p : players) {
            sb.append(p.point).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    // 같은 칸에 있는 다른 플레이어의 인덱스 (없으면 -1)
    static int findPlayerOn(int x, int y, int self) {
        for (int i = 0; i < M; i++) {
            if (i == self) continue;
            Player t = players.get(i);
            if (t.x == x && t.y == y) return i;
        }
        return -1;
    }

    // 위치에서 가장 큰 총을 주워 장착 (기존 총은 칸에 내려놓음)
    static void pickBestGun(int x, int y, Player p) {
        if (!grid[x][y].isEmpty()) {

            if (p.weapon > 0) grid[x][y].add(p.weapon);
            int best = Collections.max(grid[x][y]);
            grid[x][y].remove((Integer) best);
            p.weapon = best;
        }
    }

    // 전투 처리
    static void fight(Player a, Player b) {
        int ax = a.x, ay = a.y; // 전투 위치(두 플레이어 동일)

        int ap = a.power(), bp = b.power();
        Player winner, loser;
        if (ap == bp) { // 동점이면 능력치 큰 쪽 승
            if (a.ability >= b.ability) { winner = a; loser = b; }
            else { winner = b; loser = a; }
        } else if (ap > bp) {
            winner = a; loser = b;
        } else {
            winner = b; loser = a;
        }

        // 점수: 전투력 차의 절대값
        winner.point += Math.abs(ap - bp);

        // 패자: 현재 칸에 무기 내려놓고, 방향 회전하며 비는 칸으로 한 칸 이동
        if (loser.weapon > 0) {
            grid[ax][ay].add(loser.weapon);
            loser.weapon = 0;
        }
        moveLoser(loser);

        pickBestGun(loser.x, loser.y, loser);

        pickBestGun(ax, ay, winner);
    }

    // 패자 이동
    static void moveLoser(Player p) {
        for (int t = 0; t < 4; t++) {
            int nx = p.x + dx[p.dir];
            int ny = p.y + dy[p.dir];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && findPlayerOn(nx, ny, players.indexOf(p)) == -1) {
                p.x = nx; p.y = ny;
                return;
            }
            p.changeDir(1);
        }
    }
}