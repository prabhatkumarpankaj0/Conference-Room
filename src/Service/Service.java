package Service;

import Model.Building;
import Model.ConfRoom;
import Model.Floor;
import Repository.Repository;

import java.util.ArrayList;

public class Service {

    Repository repository = new Repository();

    public String addBuilding(String name){

        for(Building building : repository.buildingList){

            if(building.getName().equals(name)){
                return "This building already exist";
            }
        }

        repository.buildingList.add(new Building(name));

        return "Added building "+name+ " into the system.";
    }

    public String addFloor(String buildingName, int floorNumber){

        boolean buildingFound = false;
        Building currBuilding = null;

        for(Building building : repository.buildingList){

            if(building.getName().equals(buildingName)){

                buildingFound = true;
                currBuilding = building;
                break;
            }
        }

        if(buildingFound){

            if(floorNumber<= currBuilding.getTotalFloor()){
                return  "can not add this floor as total number of floor is already "+currBuilding.getTotalFloor();
            }
            else if(floorNumber == currBuilding.getTotalFloor()+1){

                currBuilding.getFloorList().add(new Floor(floorNumber));
                return "Added floor "+floorNumber+" in building "+buildingName;
            }
            else{
                return  "can not add this floor as total number of floor is only "+currBuilding.getTotalFloor();
            }

        }
        else {

            return "no such building exist";
        }
    }

    public String addConfRoom(String buildingName, int floorNumber, String confRoomName){

        boolean buildingFound = false;
        Building currBuilding = null;

        for(Building building : repository.buildingList){

            if(building.getName().equals(buildingName)){

                buildingFound = true;
                currBuilding = building;
                break;
            }
        }

        if(buildingFound){

            if(floorNumber<=0){

                return "invalid floor number";
            }
            if(floorNumber <= currBuilding.getTotalFloor()){

                Floor floor = currBuilding.getFloorList().get(floorNumber-1);

                for(ConfRoom confRoom : floor.getConfRoomList()){

                    if(confRoom.getName().equals(confRoomName)){

                        return "conference room "+confRoomName+" is already present in "+floorNumber+" of building"
                                +buildingName;
                    }
                }
                floor.getConfRoomList().add(new ConfRoom(confRoomName));
                return "Added conference room "+confRoomName+" in floor number "+floorNumber+" of building "+buildingName;
            }
        }
        else {

            return "no such building exist";
        }

        return "";
    }
    /*
    public void listConfRoom(){

        for(Building building : repository.buildingList){

            ArrayList<Floor> floorArrayList = building.getFloorList();

            for()
        }
    }

     */
}
