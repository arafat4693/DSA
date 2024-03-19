package Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Airport2 {
    private int timeToOperate = 0;
    private double delayLandSum = 0;
    private double delayTakeOffSum = 0;
    private double nrOfLanding = 0;
    private double nrOfTakeOffs = 0;
    private int maxDelayLanding = 0;
    private int maxDelayTakeoff = 0;


    private final int timeToSimulate = 5259600 / 5;
    Queue<Integer> landing = new LinkedList<>();

    Queue<Integer> takeoff = new LinkedList<>();

    public void dequeueLandOrTakeOff() {

        for (int i = 0; i < timeToSimulate; i++) {

            Random rand = new Random();
            int landingSlump = rand.nextInt(0, 100) + 1;
            int takeoffSlump = rand.nextInt(0, 100) + 1;

            if (landingSlump > 0 && landingSlump < 6) {
                landing.offer(i);
            }
            if (takeoffSlump > 0 && takeoffSlump < 6) {
                takeoff.offer(i);
            }

//            if (i==3) {
//                landing.offer(i);
//            }
//            if (i==0) {
//                takeoff.offer(i);
//            }

            if (!landing.isEmpty() && timeToOperate == 0) {
                int delayFlight = i - landing.peek();
                delayLandSum += delayFlight;
                landing.poll();
                nrOfLanding++;
                timeToOperate = 4;
                if (maxDelayLanding < delayFlight) {
                    maxDelayLanding = delayFlight;
                }
            }
            if (landing.isEmpty() && !takeoff.isEmpty() && timeToOperate == 0) {
                int delayFlight2 = i - takeoff.peek();
                delayTakeOffSum += delayFlight2;
                takeoff.poll();
                nrOfTakeOffs++;
                timeToOperate = 4;
                if (maxDelayTakeoff < delayFlight2) {
                    maxDelayTakeoff = delayFlight2;
                }
            }
            if (timeToOperate > 0) {
                timeToOperate--;
            }
        }
    }


    public double getDelayLandSum() {
        return delayLandSum;
    }

    public double getDelayTakeOffSum() {
        return delayTakeOffSum;
    }

    public int getMaxDelayLanding() {
        return 5 * maxDelayLanding;
    }

    public int getMaxDelayTakeoff() {
        return 5 * maxDelayTakeoff;
    }

    public double getAverageDelayTakeOff() {

        return 5 * (getDelayTakeOffSum() / nrOfTakeOffs);
    }

    public double getAverageDelayLanding() {
        return 5 * (getDelayLandSum() / nrOfLanding);
    }
}

