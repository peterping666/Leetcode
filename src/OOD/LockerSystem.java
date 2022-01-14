package OOD;

import java.util.ArrayList;
import java.util.List;

public class LockerSystem {
    Locker[] lockers;

    public LockerSystem(int size) {
        lockers = new Locker[size];
        for(Locker l : lockers) {
            l = new Locker(Size.small, "SDFSDF");
        }
    }
    public boolean fit() {
        
    }
}

class Locker {
    String code;
    Size size;
    boolean available;
    Package package;

    Locker(Size s, Code c) {
        code = c;
        size = s;
        package = null;
    }

    public boolean fit(Package p) {
        return size.getSize() >= p.size.getSize();
    }

    public String add(Package p) {
        if(fit(p)) {
            available = false;
            package = p;
            return new Code();
        }
        throw new IllegalArgumentException("the package can't fit in");
    }

    public boolean remove(Package p) {
        if(available) {
            return false;
        }
        code = null;
        available = true;
        package = null;
    }
}

class Package {
    String id;
    Size size;
}

class Code {

}

enum Size {
    small (1),
    mideum(2),
    large (3);

    private final int size;
    Size (int s) {
        size = s;
    }
    public int getSize() {
        return size;
    }
}
