package bike.rapido.paathshala;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrategyTest {
    @Test
    void shouldParkCarInFillUpStrategy() {
        ParkingLot firstParkingLot = new ParkingLot(2, 1);
        ParkingLot secondParkingLot = new ParkingLot(2, 2);
        ParkingLot thirdParkingLot = new ParkingLot(2, 3);

        ArrayList<ParkingLot> parkingLotsList=new ArrayList<>();
        parkingLotsList.add(firstParkingLot);
        parkingLotsList.add(secondParkingLot);
        parkingLotsList.add(thirdParkingLot);
        FillUpFirstStrategy fillUpFirstStrategy=new FillUpFirstStrategy(parkingLotsList);
        Attendee attendee=new Attendee(fillUpFirstStrategy);

        attendee.assignParkingLot(firstParkingLot);
        attendee.assignParkingLot(secondParkingLot);
        attendee.assignParkingLot(thirdParkingLot);


        Vehicle firstCar = new Vehicle();
        Vehicle secondCar = new Vehicle();
        Vehicle thirdCar = new Vehicle();
        Vehicle forthCar = new Vehicle();
        Vehicle fifthCar = new Vehicle();


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
        assertEquals(1, secondCarParkId);
        assertEquals(2, thirdCarParkId);
        assertEquals(2, fourthCarParkId);
        assertEquals(3, fifthCarParkId);

    }

    @Test
    void shouldParkCarInFillUpStrategyEvenAfterUnparking() {
        ParkingLot firstParkingLot = new ParkingLot(2, 1);
        ParkingLot secondParkingLot = new ParkingLot(2, 2);
        ParkingLot thirdParkingLot = new ParkingLot(2, 3);

        ArrayList<ParkingLot> parkingLotsList=new ArrayList<>();
        parkingLotsList.add(firstParkingLot);
        parkingLotsList.add(secondParkingLot);
        parkingLotsList.add(thirdParkingLot);
        FillUpFirstStrategy fillUpFirstStrategy=new FillUpFirstStrategy(parkingLotsList);
        Attendee attendee=new Attendee(fillUpFirstStrategy);

        attendee.assignParkingLot(firstParkingLot);
        attendee.assignParkingLot(secondParkingLot);
        attendee.assignParkingLot(thirdParkingLot);


        Vehicle firstCar = new Vehicle();
        Vehicle secondCar = new Vehicle();
        Vehicle thirdCar = new Vehicle();
        Vehicle forthCar = new Vehicle();
        Vehicle fifthCar = new Vehicle();


        attendee.parkCar(firstCar);
        attendee.parkCar(secondCar);
        attendee.unParkCar(secondCar);
        attendee.parkCar(thirdCar);
        attendee.parkCar(forthCar);
        attendee.parkCar(fifthCar);

        int firstCarParkId = attendee.getParkId(firstCar);
        int thirdCarParkId = attendee.getParkId(thirdCar);
        int fourthCarParkId = attendee.getParkId(forthCar);
        int fifthCarParkId = attendee.getParkId(fifthCar);


        assertEquals(1, firstCarParkId);
        assertEquals(1, thirdCarParkId);
        assertEquals(2, fourthCarParkId);
        assertEquals(2, fifthCarParkId);

    }
}
