package p1;

public class P1 {

    // (a) rekursiv
    public static double powRec(double a, int b) {
        // Base case
        if (b == 0) {
            return 1.0;
        }

        // negative Exponenten (sicherer als stillschweigend falsch)
        if (b < 0) {
            return 1.0 / powRec(a, -b);
        }

        // allgemeiner Fall
        return a * powRec(a, b - 1);
    }

    // (b) iterativ
    public static double powIter(double a, int b) {
        if (b == 0) {
            return 1.0;
        }

        boolean negative = (b < 0);
        int exp = negative ? -b : b;

        double result = 1.0;
        for (int i = 0; i < exp; i++) {
            result *= a;
        }

        return negative ? (1.0 / result) : result;
    }

    public static void main(String[] args) {
        // kleine Demo
        System.out.println(powRec(2.0, 10));   // 1024.0
        System.out.println(powIter(2.0, 10));  // 1024.0
        System.out.println(powRec(2.0, -3));   // 0.125
        System.out.println(powIter(2.0, -3));  // 0.125
        System.out.println(powRec(5.5, 0));    // 1.0
    }
}
