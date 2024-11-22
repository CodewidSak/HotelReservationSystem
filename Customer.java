public class Customer {
    private String name;
    private String contact;

    public Customer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }
    public Customer(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Customer Name: " + name + ", Contact: " + contact;
    }
}
