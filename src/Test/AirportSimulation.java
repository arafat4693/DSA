package Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class AirportSimulation {
    public static void main(String[] args) {
        Airport2 a = new Airport2();

        a.dequeueLandOrTakeOff();
        System.out.printf("Average Delay Landing: %.2f\n", a.getAverageDelayLanding());
        System.out.printf("Average Delay TakeOff: %.2f\n", a.getAverageDelayTakeOff());
        System.out.println("Max Delay Landing: " +a.getMaxDelayLanding());
        System.out.println("Max Delay TakeOff: " +a.getMaxDelayTakeoff());
    }
}

