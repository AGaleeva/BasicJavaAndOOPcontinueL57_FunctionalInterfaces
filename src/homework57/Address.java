package homework57;

public class Address {
    /*
    Address{String postcode, String city, String street, String house}
    */

    private String postcode;
    private String city;
    private String street;
    private String house;

    public Address(String postcode, String city, String street, String house) {
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    @Override
    public String toString() {
        return '\n' + postcode + " " + city + ", " + street +  ", " + house + ";";
    }
}
