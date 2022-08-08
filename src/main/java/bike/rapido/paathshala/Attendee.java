package bike.rapido.paathshala;

import java.util.*;

public class Attendee {
    private ArrayList<ParkingLot> parkingLotList = new ArrayList<>();
    private HashMap<Vehicle, Integer> map = new HashMap<Vehicle, Integer>();
    private String typeOfParking;

//    public Attendee(String typeOfParking) {
//        this.typeOfParking=typeOfParking;
//    }

    public void assignParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }

    public Boolean parkCar(Vehicle car) {
        if(map.containsKey(car)){
            return false;
        }

        int maximumSpace=0;
        ParkingLot maximumSpaceParkingLot = null;
        for (ParkingLot parkingLot : parkingLotList) {
            int size = parkingLot.parkingLotSize;
            int spaceOccupied = (parkingLot.vehicles).size();

            if(size - spaceOccupied > maximumSpace)
            {
                maximumSpace = size - spaceOccupied;
                maximumSpaceParkingLot = parkingLot;
            }
        }

        if (maximumSpace != 0) {
            maximumSpaceParkingLot.park(car);
            map.put(car, maximumSpaceParkingLot.parkingLotNumber);
            return true;
        }

        return false;
    }

    public Boolean unParkCar(Vehicle car) {
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
