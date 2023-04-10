package Model;

import java.util.ArrayList;

public class Building {

    private final String name;
    private int totalFloor = 0;
    private ArrayList<Floor> floorList;

    public Building(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalFloor() {
        return totalFloor;
    }

    public ArrayList<Floor> getFloorList() {
        return floorList;
    }
}
