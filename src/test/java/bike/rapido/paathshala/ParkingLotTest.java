package bike.rapido.paathshala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    ParkingLot parkingLot;
    ParkingLotOwner parkingLotOwner;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        parkingLot = new ParkingLot(3);
        parkingLotOwner = new ParkingLotOwner();
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
        Boolean unparkStatus = parkingLot.unpark(firstCar);

        assertEquals(true, unparkStatus);
    }

    @Test
    void shouldNotUnparkTheCarBeforeTheCarIsParked() {

        Vehicle firstCar = new Vehicle();

        Boolean unparkStatus = parkingLot.unpark(firstCar);

        assertEquals(false, unparkStatus);
    }

    @Test
    void shouldParkAgainAfterUnparking() {

        Vehicle firstCar = new Vehicle();

        parkingLot.park(firstCar);
        parkingLot.unpark(firstCar);
        Boolean parkStatus = parkingLot.park(firstCar);

        assertEquals(true, parkStatus);
    }

    @Test
    void shouldLetParkingLotOwnerNotifyParkingLotFilled() {

        parkingLot.register(parkingLotOwner);

        Vehicle firstCar = new Vehicle();
        Vehicle secondCar = new Vehicle();
        Vehicle thirdCar = new Vehicle();

        parkingLot.park(firstCar);
        parkingLot.park(secondCar);
        parkingLot.park(thirdCar);

        assertEquals(true, parkingLotOwner.notifying());
    }

  //  @Test
//    void shouldNotLetParkingLotOwnerNotifyWhenParkingLotNotFilled() {
//        parkingLot.register(parkingLotOwner);
//
//        Vehicle firstCar = new Vehicle();
//
//        parkingLot.park(firstCar);
//
//
//        assertEquals(false, parkingLotOwner.notifying());
//    }
}
