package kthdsa.F6;
import java.util.LinkedList;
import java.util.Queue;

public class NB16 {
    public static int antalVaxlingar(int bla, int vit, int rod) {
        if (bla == vit && vit == rod) return 0;
        if (bla + vit + rod > 45) return -1;

        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(bla, vit, rod, 0));

        while (!queue.isEmpty()) {
            State currentState = queue.poll();

            int currentBla = currentState.bla;
            int currentVit = currentState.vit;
            int currentRod = currentState.rod;
            int currentVaxlingar = currentState.vaxlingar;

            if (currentBla == currentVit && currentVit == currentRod) {
                return currentVaxlingar;
            }

            // Utför de olika växlingarna och lägg till nya tillstånd i kön
            tryToAddState(queue, currentBla - 1, currentVit + 1, currentRod + 3, currentVaxlingar + 1);
            tryToAddState(queue, currentBla + 2, currentVit - 1, currentRod + 4, currentVaxlingar + 1);
            tryToAddState(queue, currentBla + 1, currentVit + 5, currentRod - 1, currentVaxlingar + 1);
        }

        return -1; // Inga möjliga tillstånd hittades
    }

    private static void tryToAddState(Queue<State> queue, int bla, int vit, int rod, int vaxlingar) {
        if (bla >= 0 && vit >= 0 && rod >= 0 && bla + vit + rod <= 45) {
            queue.offer(new State(bla, vit, rod, vaxlingar));
        }
    }

    private static class State {
        int bla;
        int vit;
        int rod;
        int vaxlingar;

        State(int bla, int vit, int rod, int vaxlingar) {
            this.bla = bla;
            this.vit = vit;
            this.rod = rod;
            this.vaxlingar = vaxlingar;
        }
    }

    public static void main(String[] args) {
        // Testa med olika antal bollar av varje färg
        int result1 = antalVaxlingar(2, 1, 0);
        int result2 = antalVaxlingar(5, 2, 1);
        int result3 = antalVaxlingar(1, 0, 1);

        // Skriv ut resultaten
        System.out.println("Resultat för (2, 1, 0): " + getResultMessage(result1));
        System.out.println("Resultat för (5, 2, 1): " + getResultMessage(result2));
        System.out.println("Resultat för (1, 0, 1): " + getResultMessage(result3));
    }

    private static String getResultMessage(int result) {
        if (result == -1) {
            return "Ingen möjlig lösning";
        } else {
            return "Antal växlingar: " + result;
        }
    }
}
