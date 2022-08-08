package bike.rapido.paathshala;

public class SecurityPersonnel implements  ParkingLotObservers{
    boolean isCalledNotifyForFullSlot = false;
    boolean isCalledNotifyForFreeSlot = false;
    @Override
    public void notifyingForFullSlot() {
        isCalledNotifyForFullSlot = true;
    }

    @Override
    public void notifyForFreeSlot() {
        isCalledNotifyForFreeSlot = true;
    }

    public void notifyParkingLotIsFull() {
        System.out.println("Put Full Sign Board");
    }

    public void notifyParkingLotIsBackAvailable() {
        System.out.println("Remove Full Sign Board");
    }

}
