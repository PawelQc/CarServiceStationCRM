package pl.qceyco.model;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String remarks;
    private double hourlyRate;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String address, String phoneNumber, String remarks, double hourlyRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.remarks = remarks;
        this.hourlyRate = hourlyRate;
    }

    public Employee(int id, String firstName, String lastName, String address, String phoneNumber, String remarks, double hourlyRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.remarks = remarks;
        this.hourlyRate = hourlyRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", remarks='" + remarks + '\'' +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}