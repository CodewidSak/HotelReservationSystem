public class Booking {
    private Customer customer;
    private Room room;
    private String bookingDate;

    public Booking(Customer customer, Room room, String bookingDate) {
        this.customer = customer;
        this.room = room;
        this.bookingDate = bookingDate;
    }

    public void confirmBooking() {
        room.bookRoom();
        System.out.println("Booking confirmed for " + customer.getName() + " in Room " + room.getRoomNumber());
    }

    public void cancelBooking() {
        room.releaseRoom();
        System.out.println("Booking canceled for " + customer.getName() + " in Room " + room.getRoomNumber());
    }

    @Override
    public String toString() {
        return customer + ", Room: " + room + ", Booking Date: " + bookingDate;
    }
}
