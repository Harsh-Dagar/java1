package DP;

public class MinCountOfSquare {
    public static int minCount(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int a;
            a = minCount(n - (i * i));
            if (a < min) {
                min = a;
            }
        }
        return min + 1;
    }

    private static int minCount(int n, int storage[]) {
        if (n == 0 || n == 1) {
            storage[n] = n;
            return storage[n];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int a;
            if (storage[n - (i * i)] != -1) {
                a = storage[n - (i * i)];
            } else {
                a = minCount(n - (i * i));
                storage[n - (i * i)] = a;
            }
            if (a < min) {
                min = a;
            }
        }
        storage[n] = min + 1;
        return min + 1;
    }

    public static int minCountM(int n) {
        int storage[] = new int[n + 1];
        for (int i = 0; i < storage.length; i++) {
            storage[i] = -1;
        }
        return minCount(n, storage);
    }

    public static int minCountDP(int n) {
        int storage[] = new int[n + 1];
        storage[0] = 0;
        storage[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                int a = storage[i - (j * j)];
                if (a < min) {
                    min = a;
                }
            }
            storage[i] = min + 1;
        }
        return storage[n];

    }
}
