package homework57;

public class Person {
    /*
    Person{ String fName, String lName, String email, String phone, Address address}
    */

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;

    public Person(String firstName, String lastName, String email, String phone, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person: " + firstName + " " + lastName + ", '\''email: " + email + ", ph: " + phone + ", '\''address: " + address;
    }
}
