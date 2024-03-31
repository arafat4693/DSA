package ArrayAndHashing;

class ParkingSystem {
    int[] park = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        park[0] = big;
        park[1] = medium;
        park[2] = small;
    }

    public boolean addCar(int carType) {
        if(park[carType-1] == 0) return false;
        park[carType-1]--;
        return true;
    }
}
