package h2;

public class H2_main {

    // globales Array konstanter Länge (z.B. 1000 Einträge)
    private static final long[] cache = new long[1000];

    // (a) rekursiv
    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0; // defensiv, im Blatt ist n ∈ N, aber so crasht nichts
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // (b) rekursiv mit Cache
    public static long fibonacciCached(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        // Cache nur verwenden, wenn Index im Array liegt
        if (n < cache.length && cache[n] != 0) {
            return cache[n];
        }

        long val = fibonacciCached(n - 1) + fibonacciCached(n - 2);

        if (n < cache.length) {
            cache[n] = val;
        }
        return val;
    }

    // (c) iterativ
    public static long fibonacciIterative(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        long a = 1; // F1
        long b = 1; // F2
        for (int i = 3; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // benchmark: ruft nacheinander alle 3 Methoden auf und gibt Zeiten aus
    public static void benchmark(int n) {
        long t0, t1;
        long result;

        t0 = System.nanoTime();
        result = fibonacci(n);
        t1 = System.nanoTime();
        System.out.println("Result (fibonacci): " + result);
        System.out.println("Elapsed nanoseconds (fibonacci): " + (t1 - t0));

        t0 = System.nanoTime();
        result = fibonacciCached(n);
        t1 = System.nanoTime();
        System.out.println("Result (fibonacciCached): " + result);
        System.out.println("Elapsed nanoseconds (fibonacciCached): " + (t1 - t0));

        t0 = System.nanoTime();
        result = fibonacciIterative(n);
        t1 = System.nanoTime();
        System.out.println("Result (fibonacciIterative): " + result);
        System.out.println("Elapsed nanoseconds (fibonacciIterative): " + (t1 - t0));
    }

    public static void main(String[] args) {
        // Du kannst n hier frei wählen; Autograder ruft typischerweise nur die Methoden direkt auf.
        benchmark(30);
    }
}
