public class Room {
    private int roomNumber;
    private String roomType;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true; // By default, room is available
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    public void releaseRoom() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + roomType + ") - " + (isAvailable ? "Available" : "Booked");
    }
}
