package bike.rapido.paathshala;

public class ParkingLotOwner implements ParkingLotObservers {

    public void notifyParkingLotIsFull() {
        System.out.println("Put Full Sign Board");
    }

    public void notifyParkingLotIsBackAvailable() {
        System.out.println("Remove Full Sign Board");
    }
}
