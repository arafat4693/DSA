package kthdsa.L2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class AirportSimulation {
    public static void main(String[] args) {
        final int TIME_TO_SIMULATE = 5259600 / 5;
        final int REQUIRED_PROBABILITY = 6;

        Queue<Integer> landingQueue = new LinkedList<>();
        Queue<Integer> startingQueue = new LinkedList<>();

        int totalLandings = 0;
        int totalStarts = 0;
        int totalLandingWaitTime = 0;
        int totalStartingWaitTime = 0;
        int maxLandingWaitTime = 0;
        int maxStartingWaitTime = 0;
        int wait = 0;

        for (int minute = 0; minute < TIME_TO_SIMULATE; minute++) {

            Random rand = new Random();
            int landingProbability = rand.nextInt(0, 100) + 1;
            int startingProbability = rand.nextInt(0, 100) + 1;

            // Check if a plane requests landing
            if (landingProbability > 0 && landingProbability < REQUIRED_PROBABILITY) {
                landingQueue.offer(minute);
            }

            // Check if a plane requests starting
            if (startingProbability > 0 && startingProbability < REQUIRED_PROBABILITY) {
                startingQueue.offer(minute);
            }

            // Check if a plane requests landing
//            if (minute == 1) {
//                landingQueue.offer(minute);
//            }
//
//            // Check if a plane requests starting
//            if (minute == 2) {
//                startingQueue.offer(minute);
//            }

            // Process landing
            if (!landingQueue.isEmpty() && wait == 0) {
                totalLandings++;
                int waitTime = minute - landingQueue.poll();
                totalLandingWaitTime += waitTime;
                maxLandingWaitTime = Math.max(maxLandingWaitTime, waitTime);
                wait = 4;
            }

            // Process starting
            if (landingQueue.isEmpty() && !startingQueue.isEmpty() && wait == 0) {
                totalStarts++;
                int waitTime = minute - startingQueue.poll();
                totalStartingWaitTime += waitTime;
                maxStartingWaitTime = Math.max(maxStartingWaitTime, waitTime);
                wait = 4;
            }

            if (wait > 0) wait--;
    }

        double avgLandingWaitTime = 5 * ((double) totalLandingWaitTime / totalLandings);
        double avgStartingWaitTime = 5 * ((double) totalStartingWaitTime / totalStarts);

        System.out.printf("Average Delay Landing: %.2f minutes\n", avgLandingWaitTime);
        System.out.printf("Average Delay TakeOff: %.2f minutes\n", avgStartingWaitTime);
        System.out.println("Max landing wait time: " + 5*maxLandingWaitTime + " minutes");
        System.out.println("Max starting wait time: " + 5*maxStartingWaitTime + " minutes");
    }
}

