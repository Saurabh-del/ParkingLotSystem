package bike.rapido.paathshala;

public interface ParkingLotObservers {
       public void notifyingForFullSlot();
       public void notifyForFreeSlot();

       public void notifyParkingLotIsFull();

       public void notifyParkingLotIsBackAvailable();
}
