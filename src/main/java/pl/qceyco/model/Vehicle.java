package pl.qceyco.model;

import pl.qceyco.dao.CustomerDao;

import java.sql.Date;

public class Vehicle {

    private int id;
    private String model;
    private String brand;
    private int productionYear;
    private String registrationNumber;
    private Date nextReviewDate;
    private Customer customer;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, int productionYear, String registrationNumber, Date nextReviewDate, Customer customer) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.registrationNumber = registrationNumber;
        this.nextReviewDate = nextReviewDate;
        this.customer = customer;
    }

    public Vehicle(int id, String model, String brand, int productionYear, String registrationNumber, Date nextReviewDate, Customer customer) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.registrationNumber = registrationNumber;
        this.nextReviewDate = nextReviewDate;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(Date nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerById(int customerId) {
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getCustomerById(customerId);
        this.customer = customer;
    }


}

