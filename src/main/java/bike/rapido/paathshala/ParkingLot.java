package bike.rapido.paathshala;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParkingLot {

    HashSet<Vehicle> vehicles = new HashSet<>();
    int parkingLotSize;
    int parkingLotNumber;

    private List<ParkingLotObservers> observers = new ArrayList<>();

    ParkingLot(int parkingLotSize, int parkingLotNumber){
        this.parkingLotSize = parkingLotSize;
        this.parkingLotNumber=parkingLotNumber;
    }

    public void register(ParkingLotObservers observer) {
        observers.add(observer);
    }

    public void notifyForFullUpdate() {
        for(ParkingLotObservers observer: observers) {
            observer.notifyParkingLotIsFull();
        }
    }

    public void notifyForFreeSlotUpdate() {
        for(ParkingLotObservers observer: observers) {
            observer.notifyParkingLotIsBackAvailable();
        }
    }


    public Boolean park(Vehicle vehicle) {
        if(checkIfParked(vehicle) || checkIfParkingLotFull())
            return false;

        vehicles.add(vehicle);
        if(checkIfParkingLotFull()) {
            notifyForFullUpdate();
        }

        return true;
    }


    public Boolean unPark(Vehicle vehicle) {
        if(checkIfParked(vehicle)) {
            if(checkIfParkingLotFull()){
                notifyForFreeSlotUpdate();
            }
            vehicles.remove(vehicle);
            return true;
        }
        return false;
    }

    public Boolean checkIfParked(Vehicle vehicle) {
        return vehicles.contains(vehicle);
    }

    public Boolean checkIfParkingLotFull() {
        if(vehicles.size() == parkingLotSize)
            return true;
        return false;
    }

    public int numberOfCarAlreadyPark(){
        return vehicles.size();
    }

}