package boj.b11279.wldy4627;

import java.util.Scanner;

public class Main {
    public static int[] heap;
    public static int heapCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        heap = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if (x > 0) push(x);
            if (x == 0) System.out.println(pop());
        }

        return;
    }

    public static void push(int x) {
        heap[++heapCount] = x;

        int child = heapCount;
        int parent = child / 2;

        while (child > 1 && heap[child] > heap[parent]) {
            int temp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = temp;

            child = parent;
            parent = child / 2;
        }
    }

    public static int pop() {
        if (heapCount == 0) return 0;
        int popped = heap[1];

        heap[1] = heap[heapCount];
        heapCount--;

        int parent = 1;
        int child = parent * 2;

        if (child + 1 <= heapCount) {
            child = (heap[child] > heap[child + 1]) ? child : child + 1;
        }

        while (child <= heapCount && heap[child] > heap[parent]) {
            int temp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = temp;

            parent = child;
            child = parent * 2;

            if (child + 1 <= heapCount) {
                child = (heap[child] > heap[child + 1]) ? child : child + 1;
            }
        }

        return popped;
    }
}
