import java.util.ArrayList;
import java.util.List;

public class HotelManagementSystem {
    private List<Room> rooms;
    private List<Booking> bookings;

    public HotelManagementSystem() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addRoom(int roomNumber, String roomType) {
        rooms.add(new Room(roomNumber, roomType));
    }

    public void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public void showBookings() {
        System.out.println("Current Bookings:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public boolean bookRoom(Customer customer, int roomNumber, String bookingDate) {
        boolean flag = false;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                Booking booking = new Booking(customer, room, bookingDate);
                bookings.add(booking);
                booking.confirmBooking();
                flag = true;
                return flag;
            }
        }
        System.out.println("Room " + roomNumber + " is not available.");
        return flag;
    }

    public void cancelBooking(Customer customer, int roomNumber) {
        for (Booking booking : bookings) {
            if (booking.toString().contains(String.valueOf(roomNumber)) && booking.toString().contains(customer.getName())) {
                booking.cancelBooking();
                bookings.remove(booking);
                return;
            }
        }
        System.out.println("No booking found for Room " + roomNumber + " under " + customer.getName());
    }
}
