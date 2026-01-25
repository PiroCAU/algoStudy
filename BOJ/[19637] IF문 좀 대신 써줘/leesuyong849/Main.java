package BOJ_19637_IF문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Item implements Comparable<Item> {
        String name;
        int value;

        Item(String name, int value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(this.value, o.value);
        }
    }

    static int N, M;
    static List<Item> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[] name = new String[N];
        int[] value = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            value[i] = Integer.parseInt(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(br.readLine());
            int idx = lowerBound(value, x);
            sb.append(name[idx]).append('\n');
        }

        System.out.println(sb);
    }

    static int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length; // [l, r)
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
