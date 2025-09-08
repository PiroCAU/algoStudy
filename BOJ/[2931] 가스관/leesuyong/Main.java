import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static Character[][] map;
    static Queue<Node> nodes = new ArrayDeque<>();
    static Node M;
    static Node Z;
    public static final int[] nextx = {-1, 0, 1, 0};
    public static final int[] nexty = {0, 1, 0, -1};
    static boolean flag;

    static class Node {
        int x, y, dir;

        public Node(int x, int y, int dir) {
            this.x = x; this.y = y; this.dir = dir;
        }
    }

    public static void caseStraite(Node node) {
        if (node.dir == 0) {
            nodes.add(new Node(node.x, node.y+1, node.dir));
        } else {
            nodes.add( new Node(node.x, node.y - 1, node.dir));
        }
    }

    public static void caseMinus(Node node) {
        if (node.dir == 1) {
            nodes.add( new Node(node.x-1, node.y, node.dir));
        } else {
            nodes.add( new Node(node.x+1, node.y, node.dir));
        }
    }

    public static void casePlus(Node node) {
        if (node.dir == 0) {
            nodes.add( new Node(node.x-1, node.y, 3));
            nodes.add( new Node(node.x+1, node.y, 1));
            nodes.add( new Node(node.x, node.y + 1, 0));
        } else if (node.dir == 1) {
            nodes.add( new Node(node.x-1, node.y, 3));
            nodes.add( new Node(node.x, node.y - 1, 2));
            nodes.add( new Node(node.x, node.y + 1, 0));
        } else if (node.dir == 2) {
            nodes.add( new Node(node.x-1, node.y, 3));
            nodes.add( new Node(node.x+1, node.y, 1));
            nodes.add( new Node(node.x, node.y - 1, 2));
        } else {
            nodes.add( new Node(node.x, node.y - 1, 2));
            nodes.add( new Node(node.x+1, node.y, 1));
            nodes.add( new Node(node.x, node.y + 1, 0));
        }
    }

    public static void case1(Node node ) {
        if (node.dir == 1) {
            nodes.add(new Node(node.x, node.y+1, 0));
        } else {
            nodes.add( new Node(node.x+1, node.y, 3));
        }
    }

    public static void case2(Node node) {
        if (node.dir == 0) {
            nodes.add(new Node(node.x+1, node.y, 3));
        } else {
            nodes.add( new Node(node.x, node.y-1, 2));
        }
    }

    public static void case3(Node node) {
        if (node.dir == 0) {
            nodes.add(new Node(node.x-1, node.y, 1));
        } else {
            nodes.add( new Node(node.x, node.y-1, 2));
        }
    }

    public static void case4(Node node) {
        if (node.dir == 3) {
            nodes.add(new Node(node.x, node.y+1, 0));
        } else {
            nodes.add( new Node(node.x-1, node.y, 1));
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new Character[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'M') {
                    M = new Node(i, j, -1);
                } else if (map[i][j] == 'Z') {
                    Z = new Node(i, j, -1);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int nx = M.x + nextx[i];
            int ny = M.y + nexty[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                continue;
            }
            if (map[nx][ny] != '.') {
                nodes.add(new Node(nx, ny, i));
            }
        }

        Node error = cal();
        Character result = null;

        Character[] fixingList = {'|', '-', '+', '1', '2', '3', '4'};

        for (int i = 0; i < 7; i++) {
            map[error.x][error.y] = fixingList[i];

            cal();
            if (flag) {
                result = fixingList[i];
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(error.x).append(" ").append(error.y).append(" ").append(result);
        System.out.println(sb.toString());
    }

    private static Node cal() {
        Node error = null;
        while(true) {
            if (nodes.isEmpty()) {
                return error;
            }

            Node poll = nodes.poll();

            Character c = map[poll.x][poll.y];
            //도팍한 경우: 성공으로 표시하고 종료
            if (c == 'Z' && nodes.isEmpty()) {
                flag = true;
                break;
            }

            //각 케이스 별로 이동 및 저장
            if (c == '|') {
                caseStraite(poll);
            } else if (c == '-') {
                caseMinus(poll);
            } else if (c == '+') {
                casePlus(poll);
            } else if (c == '1') {
                case1(poll);
            } else if (c == '2') {
                case2(poll);
            }else if (c == '3') {
                case3(poll);
            }else if (c == '4') {
                case4(poll);
            } else {
                error = poll;
                break;
            }
        }
        return error;
    }
}
