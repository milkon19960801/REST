package models;

public class Friend {

    private String name;
    private String address;
    private String phoneNumber;
    private int    id;

    public Friend(){}
    public Friend(String name,String address,String phoneNumber,int id) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.id = id;
    }

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setId(int id) { this.id = id; }

    public Friend(String Info) { this.name = Info; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getName() { return this.name; }
    public int getId() { return id; }
}

