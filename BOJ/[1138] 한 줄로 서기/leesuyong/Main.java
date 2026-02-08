package BOJ_1138_한줄로서기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] left = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) left[i] = Integer.parseInt(st.nextToken());

        List<Integer> line = new ArrayList<>();

        // 키 큰 사람부터
        for (int h = N; h >= 1; h--) {

            line.add(left[h - 1], h);
        }

        StringBuilder sb = new StringBuilder();
        for (int x : line) sb.append(x).append(' ');
        System.out.println(sb);
    }
}
