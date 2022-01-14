package OOD;

public class ParkingLot {
    private Level[] levels;

    public ParkingLot(int numOfLevels, int numOfSpotPerLevel) {
        levels = new Level[numOfLevels];
        for(int i = 0; i < numOfLevels; i++) {
            levels[i] = new Level(numOfSpotPerLevel);
        }
    }

    public Boolean hasSpot(Vehicle v) {
        for(Level level : levels) {
            if(level.hasSpot(v)) {
                return true;
            }
        }
        return false;
    }
    public Boolean park(Vehicle v) {
        for(Level level : levels) {
            if(level.park(v)) {
                return true;
            }
        }
        return false;
    }
    public Boolean leave(Vehicle v) {
        for(Level level : levels) {
            if(level.leave(v)) {
                return true;
            }
        }
        return false;
    }
}

class Level {
    private final ParkingSpot[] spots;

    Level(int numOfSpots) {
        spots = new ParkingSpot[numOfSpots];
        int i = 0;
        while(i++ < numOfSpots / 2){
            spots[i] = new ParkingSpot(VehicleSize.Compact);
        }
        while(i++ < numOfSpots){
            spots[i] = new ParkingSpot(VehicleSize.Large);
        }
    }

    boolean hasSpot(Vehicle v) {
        for(ParkingSpot spot : spots) {
            if(spot.fit(v)) {
                return true;
            }
        }
        return false;
    }

    boolean park(Vehicle v) {
        for(ParkingSpot spot : spots) {
            if(spot.fit(v)) {
                spot.park(v);
                return true;
            }
        }
        return false;
    }
    Boolean leave(Vehicle v) {
        for(ParkingSpot spot : spots) {
            if(v == spot.getVehicle()) {
                spot.leave();
                return true;
            }
        }
        return false;
    }
}

class ParkingSpot {
    private final VehicleSize size;

    public VehicleSize getSize() {
        return size;
    }

    private Vehicle vehicle;

    ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    Boolean fit(Vehicle v) {
        if(vehicle == null) {
//            1.	use if/else to compare size
//            2.	add a size attribute in enum VehicleSize and use it for comparision
        }
        return false;
    }
    void park(Vehicle v) {
        vehicle = v;
    }
    void leave() {
        vehicle = null;
    }
    Vehicle getVehicle() {
        return vehicle;
    }
}

abstract class Vehicle {
    //protected final String plate;

    public abstract VehicleSize getSize();
}

class Car extends Vehicle {
    @override
    public VehicleSize getSize() {
        return VehicleSize.Compact;
    }
}

class Bus extends Vehicle {
    @override
    public VehicleSize getSize() {
        return VehicleSize.Large;
    }
}


enum VehicleSize {
    // Compact, Large
    Compact (1),
    Large (2);

    private final int size;

    VehicleSize (int size) {
        this. size = size;
    }

    public int getSize() {
        return size;
    }
}

//    VehicleSize vehicleSize = VehicleSize.Compact;
//    if(vehicleSize == VehicleSize.Compact) {
//        ……
//    } else if(vehicleSize == VehicleSize.Large) {
//        ……
//    }
//
//    int size = vehicleSize.getSize();

