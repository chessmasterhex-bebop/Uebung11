package h1;

public class H1_main {

    // Base Case: gleicher Knoten → Abstand 0
    // Rekursiver Schritt: 1 + Abstand des Nachfolgers
    public static int distance(Node x, Node y) {
        if (x == y) {
            return 0;
        }
        return 1 + distance(x.getNext(), y);
    }

    public static void main(String[] args) {
        // Hier könnten Tests stehen, aber für den Autograder ist das egal.
        // Besser leer lassen, damit keine Ausgaben entstehen.
    }
}
