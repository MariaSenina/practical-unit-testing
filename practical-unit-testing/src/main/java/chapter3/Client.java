package chapter3;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private List<Address> addresses;
    private String email;

    public Client(String email) {
        this.email = email;
    }

    public Client() {
        addresses = new ArrayList<>();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "addresses=" + addresses +
                ", email='" + email + '\'' +
                '}';
    }
}
