package bike.rapido.paathshala;

import java.util.List;

public class EvenDistributionStrategy implements Strategy{

    private List<ParkingLot> parkingLots;

    public EvenDistributionStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }

    @Override
    public ParkingLot parkTheCarUsingStrategy() {
        ParkingLot parkingLot1 = null;
        double min = Double.MAX_VALUE;

        for(ParkingLot parkingLot:parkingLots) {
            double filledPercentage = getFilledPercentage(parkingLot);
            //System.out.println(filledPercentage);
            if (filledPercentage < min) {
                min = filledPercentage;
                parkingLot1 = parkingLot;
            }

        }
        return parkingLot1;
    }
    private double getFilledPercentage(ParkingLot parkingLot) {
        return (double)((parkingLot.numberOfcarAlreadyPark()/ parkingLot.parkingLotSize))*100;
    }
}
