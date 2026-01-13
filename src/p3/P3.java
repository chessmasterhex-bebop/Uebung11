package p3;

public class P3 {

    // Rekursiv: berechnet das Kapital nach n Jahren bei 5% p.a., jedes Jahr Abrunden auf volle Euro.
    public static int capitalAfterYears(int capital, int n) {
        // Base case: 0 Jahre -> unverändert
        if (n == 0) {
            return capital;
        }

        // 5% Zinsen, danach abrunden
        int next = (int) Math.floor(capital * 1.05);

        // Rekursion: ein Jahr "verbrauchen"
        return capitalAfterYears(next, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(capitalAfterYears(1004, 1)); // 1054
        System.out.println(capitalAfterYears(1004, 2)); // 1106 (1054*1.05=1106.7 -> 1106)
        System.out.println(capitalAfterYears(1000, 0)); // 1000
    }
}
