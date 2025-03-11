public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());

            // 공통 부분이 없는 경우
            if (x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1) {
                System.out.println("d");
            }
            // 점에서 만나는 경우
            else if ((x2 == x3 && y2 == y3) || (x1 == x4 && y2 == y3) ||
                    (x2 == x3 && y1 == y4) || (x1 == x4 && y1 == y4)) {
                System.out.println("c");
            }
            // 선분에서 만나는 경우
            else if (x2 == x3 || x1 == x4 || y2 == y3 || y1 == y4) {
                System.out.println("b");
            }
            // 내부에서 겹치는 경우
            else {
                System.out.println("a");
            }
        }

    }
}