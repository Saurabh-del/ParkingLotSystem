package bike.rapido.paathshala;

import java.util.List;

public class EvenDistributionStrategy implements Strategy{

    private List<ParkingLot> parkingLots;

    public EvenDistributionStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }

    @Override
    public ParkingLot parkTheCarUsingStrategy() {
        double minfilledPercentage=Integer.MAX_VALUE;
        ParkingLot expectedParkingLot=parkingLots.get(0);
      for(ParkingLot parkingLot:parkingLots){
             System.out.println(getFilledPercentage(parkingLot));
          }
        return expectedParkingLot;
      }

    private double getFilledPercentage(ParkingLot parkingLot) {

        return (double)((parkingLot.numberOfCarAlreadyPark() * 100 * 1.0)/ parkingLot.parkingLotSize);

    }
}
