package bike.rapido.paathshala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParkingLotTest {

    ParkingLot parkingLot;
    ParkingLotOwner parkingLotOwner;
    SecurityPersonnel securityPersonnel;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        parkingLot = new ParkingLot(3, 1);
        parkingLotOwner = new ParkingLotOwner();
        securityPersonnel = new SecurityPersonnel();
    }

    @Test
    void shouldParkTheCar() {

        Vehicle firstCar = new Vehicle();

        Boolean result = parkingLot.park(firstCar);

        assertEquals(true, result);
    }

    @Test
    void shouldUnparkTheCar() {

        Vehicle firstCar = new Vehicle();

        parkingLot.park(firstCar);
        Boolean unparkStatus = parkingLot.unPark(firstCar);

        assertEquals(true, unparkStatus);
    }

    @Test
    void shouldNotUnparkTheCarBeforeTheCarIsParked() {

        Vehicle firstCar = new Vehicle();

        Boolean unparkStatus = parkingLot.unPark(firstCar);

        assertEquals(false, unparkStatus);
    }

    @Test
    void shouldParkAgainAfterUnparking() {

        Vehicle firstCar = new Vehicle();

        parkingLot.park(firstCar);
        parkingLot.unPark(firstCar);
        Boolean parkStatus = parkingLot.park(firstCar);

        assertEquals(true, parkStatus);
    }

    @Test
    void shouldLetParkingLotOwnerNotifyParkingLotFilled() {

        ParkingLotOwner ownerSpy = Mockito.spy(new ParkingLotOwner());
        parkingLot.register(ownerSpy);

        Vehicle firstCar = new Vehicle();
        Vehicle secondCar = new Vehicle();
        Vehicle thirdCar = new Vehicle();

        parkingLot.park(firstCar);
        parkingLot.park(secondCar);
        parkingLot.park(thirdCar);


        verify(ownerSpy,times(1)).notifyParkingLotIsFull();

    }

    @Test
    void shouldLetSecurityPersonNotifyParkingLotFilled() {

        ParkingLotOwner securityPersonnelSpy = Mockito.spy(new ParkingLotOwner());
        parkingLot.register(securityPersonnelSpy);
        Vehicle firstCar = new Vehicle();
        Vehicle secondCar = new Vehicle();
        Vehicle thirdCar = new Vehicle();

        parkingLot.park(firstCar);
        parkingLot.park(secondCar);
        parkingLot.park(thirdCar);


        verify(securityPersonnelSpy,times(1)).notifyParkingLotIsFull();
    }

    @Test
    void shouldNotLetParkingLotOwnerNotifyWhenParkingLotNotFilled() {
        ParkingLotOwner ownerSpy = Mockito.spy(new ParkingLotOwner());
        parkingLot.register(ownerSpy);

        Vehicle firstCar = new Vehicle();

        parkingLot.park(firstCar);

        verify(ownerSpy,times(0)).notifyParkingLotIsFull();
    }

    @Test
    void shouldNotifyOwnerWhenSlotsAreBackAvailable() {
        ParkingLotOwner ownerSpy = Mockito.spy(new ParkingLotOwner());
        parkingLot.register(ownerSpy);

        Vehicle firstCar = new Vehicle();
        Vehicle secondCar = new Vehicle();
        Vehicle thirdCar = new Vehicle();
        parkingLot.park(firstCar);
        parkingLot.park(secondCar);
        parkingLot.park(thirdCar);
        parkingLot.unPark(thirdCar);

        verify(ownerSpy,times(1)).notifyParkingLotIsFull();
        verify(ownerSpy,times(1)).notifyParkingLotIsBackAvailable();
    }

}
