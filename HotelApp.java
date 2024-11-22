import java.util.Scanner;

public class HotelApp {
    public static void main(String[] args) {
        HotelManagementSystem hotelSystem = new HotelManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        // Adding rooms to the hotel
        hotelSystem.addRoom(101, "Single");
        hotelSystem.addRoom(102, "Double");
        hotelSystem.addRoom(103, "Suite");

        // Taking customer details and booking information from the user
        while(flag){
            System.out.println("Welcome to the Hotel Management System!");
            System.out.print("Enter Customer Name: ");
            String customerName1 = scanner.nextLine();
            System.out.print("Enter Customer Contact: ");
            String customerContact1 = scanner.nextLine();
            Customer customer1 = new Customer(customerName1, customerContact1);
            hotelSystem.showAvailableRooms();
            System.out.print("Enter Room Number to Book for " + customer1.getName() + ": ");
            int roomNumber1 = scanner.nextInt();
            scanner.nextLine();  // consume the newline
            System.out.print("Enter Booking Date (YYYY-MM-DD): ");
            String bookingDate1 = scanner.nextLine();
            boolean booked = hotelSystem.bookRoom(customer1, roomNumber1, bookingDate1);
            if(!booked) hotelSystem.showAvailableRooms();
            System.out.print("Add more customer :- yes or no ?");
            String add = scanner.nextLine();
            if(add.equals("no")) flag = false;
        }
        System.out.print("Show Customer Details :- yes or no ?");
        String show = scanner.nextLine();
        if(show.equals("yes")) hotelSystem.showBookings();
        
        // Cancel a booking (for example, cancel Customer 1's booking)
        System.out.print("Cancel booking  :- yes or no ?");
        String cancel = scanner.nextLine();
        if(cancel.equals("yes")){ 
        System.out.print("Enter Room Number to Cancel for : ");
        int cancelRoomNumber = scanner.nextInt();
        // System.out.print("Enter customer Name to Cancel for : ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);
        hotelSystem.cancelBooking(customer, cancelRoomNumber);
        }
        hotelSystem.showAvailableRooms();
        // Show available rooms after cancellation
        

        scanner.close();
    }
}
