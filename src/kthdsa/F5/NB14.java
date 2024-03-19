package kthdsa.F5;

public class NB14 {
    private static int calculateMinAmount(int goal) {
        // Basfall: Om målet är 1, då krävs 0 kronor
        if (goal == 1) {
            return 0;
        }

        // Beräkna det lägsta beloppet genom att pröva alla möjliga mynt och rekursivt söka efter det minsta beloppet
        int minAmount = Integer.MAX_VALUE;

        // Försök multiplicera poängen med 3 genom att använda en 10-krona
        if (goal % 3 == 0) {
            int amount10 = 10 + calculateMinAmount(goal / 3);
            minAmount = Math.min(minAmount, amount10);
        }

        // Försök addera 4 till poängen genom att använda en 5-krona
        int amount5 = 5 + calculateMinAmount(goal - 4);
        minAmount = Math.min(minAmount, amount5);

        return minAmount;
    }

    public static void main(String[] args) {
        System.out.println(calculateMinAmount(109));
    }
}
