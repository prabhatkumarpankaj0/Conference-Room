package Model;

import java.util.ArrayList;

public class Floor {

    private final int floorNumber;
    private ArrayList<ConfRoom> confRoomList;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public ArrayList<ConfRoom> getConfRoomList() {
        return confRoomList;
    }
}
