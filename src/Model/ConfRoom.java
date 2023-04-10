package Model;

import java.util.ArrayList;

public class ConfRoom {

    private final String name;
    private ArrayList<Booking> bookingList;

    public ConfRoom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
