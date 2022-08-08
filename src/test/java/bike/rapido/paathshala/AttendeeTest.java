package bike.rapido.paathshala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AttendeeTest {

    private Attendee attendee;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        attendee = new Attendee();
    }

    @Test
    void shouldAttendeeParkCarIfLotsHaveSpace() {
        ParkingLot firstParkingLot = new ParkingLot(3, 1);
        ParkingLot secondParkingLot = new ParkingLot(3, 2);
        ParkingLot thirdParkingLot = new ParkingLot(3, 3);
        Vehicle car=new Vehicle();

        attendee.assignParkingLot(firstParkingLot);
        attendee.assignParkingLot(secondParkingLot);
        attendee.assignParkingLot(thirdParkingLot);


        Boolean isParked = attendee.parkCar(car);


        assertTrue(isParked);
    }

    @Test
    void attendeeShouldNotParkCarIfLotIsFull() {
        Vehicle firstCar = new Vehicle();
        Vehicle secondCar = new Vehicle();
        Attendee attendee = new Attendee();
        ParkingLot firstParkingLot = new ParkingLot(1, 1);
        attendee.assignParkingLot(firstParkingLot);
        attendee.parkCar(firstCar);

        Boolean isPark = attendee.parkCar(secondCar);

        assertFalse(isPark);
    }

    @Test
    void attendeeShouldNotAllowedToParkCarIfLotsIsFull() {
        Vehicle firstCar = new Vehicle();
        Vehicle secondCar = new Vehicle();
        Vehicle thirdCar = new Vehicle();
        Vehicle forthCar = new Vehicle();
        Vehicle fifthCar=new Vehicle();

        ParkingLot firstParkingLot = new ParkingLot(1, 1);
        ParkingLot secondParkingLot = new ParkingLot(2, 2);
        ParkingLot thirdParkingLot = new ParkingLot(1, 3);
        attendee.assignParkingLot(firstParkingLot);
        attendee.assignParkingLot(secondParkingLot);
        attendee.assignParkingLot(thirdParkingLot);
        attendee.parkCar(firstCar);
        attendee.parkCar(secondCar);
        attendee.parkCar(thirdCar);
        attendee.parkCar(forthCar);



        Boolean result = attendee.parkCar(fifthCar);

        assertFalse(result);
    }

    @Test
    void attendeeShouldUnParkCarIfPresentInParkingLot() {
        Vehicle car = new Vehicle();
        Attendee attendee = new Attendee();
        ParkingLot firstParkingLot = new ParkingLot(1, 1);
        attendee.assignParkingLot(firstParkingLot);
        attendee.parkCar(car);


        Boolean result = attendee.unParkCar(car);


        assertTrue(result);
    }

    @Test
    void shouldAttendeeNotAllowedToUnParkCarIfNotPresentInAnyParkingLot() {
        Vehicle car = new Vehicle();
        Attendee attendee = new Attendee();
        ParkingLot firstParkingLot = new ParkingLot(1, 1);
        attendee.assignParkingLot(firstParkingLot);


        Boolean result = attendee.unParkCar(car);


        assertFalse(result);
    }

    @Test
    void shouldParkCarInEvenlyDistributedManner(){
        Vehicle firstCar = new Vehicle();
        Vehicle secondCar = new Vehicle();
        Vehicle thirdCar = new Vehicle();
        Vehicle forthCar = new Vehicle();
        Vehicle fifthCar = new Vehicle();

        ParkingLot firstParkingLot = new ParkingLot(2, 1);
        ParkingLot secondParkingLot = new ParkingLot(2, 2);
        ParkingLot thirdParkingLot = new ParkingLot(2, 3);

        attendee.assignParkingLot(firstParkingLot);
        attendee.assignParkingLot(secondParkingLot);
        attendee.assignParkingLot(thirdParkingLot);

        attendee.parkCar(firstCar);
        attendee.parkCar(secondCar);
        attendee.parkCar(thirdCar);
        attendee.parkCar(forthCar);
        attendee.parkCar(fifthCar);

        int firstCarParkId = attendee.getParkId(firstCar);
        int secondCarParkId = attendee.getParkId(secondCar);
        int thirdCarParkId = attendee.getParkId(thirdCar);
        int fourthCarParkId = attendee.getParkId(forthCar);
        int fifthCarParkId = attendee.getParkId(fifthCar);


        assertEquals(1, firstCarParkId);
        assertEquals(2, secondCarParkId);
        assertEquals(3, thirdCarParkId);
        assertEquals(1, fourthCarParkId);
        assertEquals(2, fifthCarParkId);

    }

    @Test
    void shouldParkCarInEvenlyDistributedMannerEvenAfterUnParkingCar() {
        Vehicle firstCar = new Vehicle();
        Vehicle secondCar = new Vehicle();
        Vehicle thirdCar = new Vehicle();
        Vehicle forthCar = new Vehicle();
        Vehicle fifthCar = new Vehicle();

        ParkingLot firstParkingLot = new ParkingLot(2, 1);
        ParkingLot secondParkingLot = new ParkingLot(2, 2);
        ParkingLot thirdParkingLot = new ParkingLot(2, 3);

        attendee.assignParkingLot(firstParkingLot);
        attendee.assignParkingLot(secondParkingLot);
        attendee.assignParkingLot(thirdParkingLot);

        attendee.parkCar(firstCar);
        attendee.parkCar(secondCar);
        attendee.parkCar(thirdCar);
        attendee.unParkCar(thirdCar);
        attendee.parkCar(forthCar);
        attendee.unParkCar(forthCar);
        attendee.parkCar(fifthCar);

        int firstCarParkId = attendee.getParkId(firstCar);
        int secondCarParkId = attendee.getParkId(secondCar);
        int fifthCarParkId = attendee.getParkId(fifthCar);


        assertEquals(1, firstCarParkId);
        assertEquals(2, secondCarParkId);
        assertEquals(3, fifthCarParkId);

    }
}
