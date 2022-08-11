package bike.rapido.paathshala;

import java.util.List;

public class EvenDistributionStrategy implements Strategy{

    private List<ParkingLot> parkingLots;

    public EvenDistributionStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }

    @Override
    public ParkingLot parkTheCarUsingStrategy() {
        ParkingLot parkingLotToPark = null;
        double minimumSpaceInParkingLot = Double.MAX_VALUE;

        for(ParkingLot parkingLot:parkingLots) {
            double filledPercentage = getFilledPercentage(parkingLot);

            if (filledPercentage < minimumSpaceInParkingLot) {
                minimumSpaceInParkingLot = filledPercentage;
                parkingLotToPark = parkingLot;
            }

        }
        return parkingLotToPark;
      }

    private double getFilledPercentage(ParkingLot parkingLot) {

        return ((parkingLot.numberOfCarAlreadyPark() * 100 * 1.0)/ parkingLot.parkingLotSize);

    }
}
