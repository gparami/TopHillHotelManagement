package ca.uottawa.tophillhotelmanagement;

/**
 * Created by parami on 2017-11-29.
 */

public class Room extends Hotel {

    private String roomNumber;
    private boolean cleanStatus;

    //Getters
    public String getRoomNumber() { return roomNumber; }
    public boolean isClean() { return cleanStatus; }

    //Setters
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public void cleaned() { this.cleanStatus = true; } //sets the room to clean
    public void dirty() { this.cleanStatus = false; } //sets the room to dirty
}
