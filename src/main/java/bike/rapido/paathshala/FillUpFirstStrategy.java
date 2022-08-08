package bike.rapido.paathshala;

import java.util.ArrayList;
import java.util.List;

public class FillUpFirstStrategy implements Strategy{

    private List<ParkingLot> parkingLots;

    public FillUpFirstStrategy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingLot parkTheCarUsingStrategy() {

        for(ParkingLot parkingLot:parkingLots){
            if(!parkingLot.checkIfParkingLotFull()){
                return parkingLot;
            }
        }
        return null;
    }
}
