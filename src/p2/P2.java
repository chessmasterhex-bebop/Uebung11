package p2;

public class P2 {

    // (a) rekursiv: n ist eine Zweierpotenz (1,2,4,8,...)
    public static int log2Rec(int n) {
        // Base case: 2^0 = 1
        if (n == 1) {
            return 0;
        }
        // allgemeiner Fall: log2(n) = 1 + log2(n/2)
        return 1 + log2Rec(n / 2);
    }

    // (b) iterativ
    public static int log2Iter(int n) {
        int count = 0;
        while (n > 1) {
            n = n / 2;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(log2Rec(1));   // 0
        System.out.println(log2Rec(16));  // 4
        System.out.println(log2Iter(32)); // 5
        System.out.println(log2Iter(8));  // 3
    }
}
