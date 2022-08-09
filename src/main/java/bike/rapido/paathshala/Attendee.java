package bike.rapido.paathshala;

import java.util.*;

public class Attendee {
    private ArrayList<ParkingLot> parkingLotList = new ArrayList<>();
    private HashMap<Vehicle, Integer> map = new HashMap<Vehicle, Integer>();
    private Strategy strategy;


    public Attendee(){
        this.strategy=null;
    }
    public Attendee(Strategy strategy) {
        this.strategy=strategy;
    }


    public void assignParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }

    public Boolean parkCar(Vehicle car) {
        if(map.containsKey(car)){
            return false;
        }

        if(strategy == null)
        {
            for(ParkingLot parkingLot:parkingLotList)
            {
                if(!parkingLot.checkIfParkingLotFull()) {
                    parkingLot.park(car);
                    map.put(car, parkingLot.parkingLotNumber);
                    return true;
                }
            }
            return false;
        }


        ParkingLot parkingLotToParkCar=strategy.parkTheCarUsingStrategy();
        if(parkingLotToParkCar.checkIfParkingLotFull()){
            return false;
        }

        if(parkingLotToParkCar != null){
            parkingLotToParkCar.park(car);
            map.put(car, parkingLotToParkCar.parkingLotNumber);
            return true;
        }
        return false;
    }

    public Boolean unParkCar(Vehicle car) {
        if(!map.containsKey(car)){
            return false;
        }
        for (ParkingLot parkingLot : parkingLotList) {
            Boolean result = parkingLot.unPark(car);

            if (result) {
                map.remove(car);
                return true;
            }
        }
        return false;
    }

    public int getParkId(Vehicle car) {
        if(map.containsKey(car)){
            return map.get(car);
        }
        return 0;
    }
}
