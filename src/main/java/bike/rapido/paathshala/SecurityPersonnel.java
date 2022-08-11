package bike.rapido.paathshala;

public class SecurityPersonnel implements  ParkingLotObservers{
    public void notifyParkingLotIsFull() {
        System.out.println("Put Full Sign Board");
    }

    public void notifyParkingLotIsBackAvailable() {
        System.out.println("Remove Full Sign Board");
    }

}
