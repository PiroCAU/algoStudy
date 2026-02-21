import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int p, m;
    private static ArrayList<Room> roomList;

    static class Room {
        int minLevel, maxLevel;
        int playerCnt;
        boolean started;
        ArrayList<Player> players;

        private Room(int level, String nickname) {
            players = new ArrayList<>();
            started = m == 1;

            minLevel = level - 10;
            maxLevel = level + 10;

            players.add(new Player(level, nickname));

            playerCnt = 1;
        }

        boolean insert(int level, String nickname) {
            if (started)
                return false; // 이미 시작하면 참여 불가
            if (maxLevel < level || level < minLevel)
                return false; // 레벨 캡 확인

            playerCnt++;
            players.add(new Player(level, nickname));

            // 게임 시작 여부 확인
            if (playerCnt == m)
                started = true;

            return true;
        }
    }

    static class Player {
        int level;
        String nickname;

        private Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        roomList = new ArrayList<>();

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // p 개의 줄: 플레이어레벨 닉네임
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            // 1. 매칭 가능한 방 있는지 확인하고, 있으면 넣어주기
            boolean canMatched = false;
            for (Room room : roomList) {
                canMatched = room.insert(l, n);

                if (canMatched)
                    break; // 가장 먼저 참여 가능한 방에 참여
            }

            // 2. 없으면 방 만들기
            if (!canMatched) {
                roomList.add(new Room(l, n));
            }
        }

        for (Room room : roomList) {
            sb.append(room.started ? "Started!\n" : "Waiting!\n");

            room.players.sort((o1, o2) -> o1.nickname.compareTo(o2.nickname));

            for (Player player : room.players) {
                sb.append(player.level).append(" ").append(player.nickname).append('\n');
            }
        }

        System.out.println(sb);

    }
}

/*
 * 1. 매칭 가능한 방 있는지 확인
 * - 매칭 가능 여부: 처음 입장한 플레이어 레벨 +- 10
 * 2-1. 매칭 가능한 방 없으면 새로 만들어서 입장
 * 2-2. 매칭 가능한 방 있으면 입장 후 정원이 찰 때까지 대기
 * -> 여러 개면 먼저 생성된 방에 입장
 * 
 * 3. 정원이 모두 차면 게임 시작
 * 
 * 플레이어 수 p, 닉네임 n, 레벨 l, 방 한개의 정원 m
 * 최종적으로 만들어진 방의 상태와 입장 플레이어를 출력
 * 
 * 출력
 * - 모든 생성된 방에 대해
 * 1) 게임의 시작 유무
 * 2) 플레이어들의 레벨 아이디
 * - 플레이어의 정보: 닉네임 사전 순
 * - 시작: Started! 대기: Waiting!
 */
