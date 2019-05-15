package pl.qceyco.model;

import pl.qceyco.dao.EmployeeDao;
import pl.qceyco.dao.StatusDao;
import pl.qceyco.dao.VehicleDao;

import java.sql.Date;

public class Order {

    private int id;
    private Date acceptanceDate;
    private Date plannedRepairStartDate;
    private Date actualRepairStartDate;
    private Employee assignedEmployee;
    private String problemDescription;
    private String repairDescription;
    private Status repairStatus;
    private Vehicle repairedVehicle;
    private double costFinalToPay;
    private double costUsedParts;
    private double costEmployeeHourlyRate;
    private double repairTimeInHours;

    public Order() {
    }

    public Order(Date acceptanceDate, Date plannedRepairStartDate, Date actualRepairStartDate, Employee assignedEmployee, String problemDescription, String repairDescription, Status repairStatus, Vehicle repairedVehicle, double costFinalToPay, double costUsedParts, double repairTimeInHours) {
        this.acceptanceDate = acceptanceDate;
        this.plannedRepairStartDate = plannedRepairStartDate;
        this.actualRepairStartDate = actualRepairStartDate;
        this.assignedEmployee = assignedEmployee;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.repairStatus = repairStatus;
        this.repairedVehicle = repairedVehicle;
        this.costFinalToPay = costFinalToPay;
        this.costUsedParts = costUsedParts;
        this.costEmployeeHourlyRate = assignedEmployee.getHourlyRate();
        this.repairTimeInHours = repairTimeInHours;
    }

    public Order(int id, Date acceptanceDate, Date plannedRepairStartDate, Date actualRepairStartDate, Employee assignedEmployee, String problemDescription, String repairDescription, Status repairStatus, Vehicle repairedVehicle, double costFinalToPay, double costUsedParts, double repairTimeInHours) {
        this.id = id;
        this.acceptanceDate = acceptanceDate;
        this.plannedRepairStartDate = plannedRepairStartDate;
        this.actualRepairStartDate = actualRepairStartDate;
        this.assignedEmployee = assignedEmployee;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.repairStatus = repairStatus;
        this.repairedVehicle = repairedVehicle;
        this.costFinalToPay = costFinalToPay;
        this.costUsedParts = costUsedParts;
        this.costEmployeeHourlyRate = assignedEmployee.getHourlyRate();
        this.repairTimeInHours = repairTimeInHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(Date acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public Date getPlannedRepairStartDate() {
        return plannedRepairStartDate;
    }

    public void setPlannedRepairStartDate(Date plannedRepairStartDate) {
        this.plannedRepairStartDate = plannedRepairStartDate;
    }

    public Date getActualRepairStartDate() {
        return actualRepairStartDate;
    }

    public void setActualRepairStartDate(Date actualRepairStartDate) {
        this.actualRepairStartDate = actualRepairStartDate;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public Status getRepairStatus() {
        return repairStatus;
    }

    public Vehicle getRepairedVehicle() {
        return repairedVehicle;
    }

    public double getCostFinalToPay() {
        return costFinalToPay;
    }

    public void setCostFinalToPay(double costFinalToPay) {
        this.costFinalToPay = costFinalToPay;
    }

    public double getCostUsedParts() {
        return costUsedParts;
    }

    public void setCostUsedParts(double costUsedParts) {
        this.costUsedParts = costUsedParts;
    }

    public double getCostEmployeeHourlyRate() {
        return costEmployeeHourlyRate;
    }

    public void setCostEmployeeHourlyRate(double costEmployeeHourlyRate) {
        this.costEmployeeHourlyRate = costEmployeeHourlyRate;
    }

    public double getRepairTimeInHours() {
        return repairTimeInHours;
    }

    public void setRepairTimeInHours(double repairTimeInHours) {
        this.repairTimeInHours = repairTimeInHours;
    }

    public void setAssignedEmployeeById(int employeeId) {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee assignedEmployee = employeeDao.getEmployeeById(employeeId);
        this.assignedEmployee = assignedEmployee;
    }

    public void setRepairedVehicleById(int vehicleId) {
        VehicleDao vehicleDao = new VehicleDao();
        Vehicle repairedVehicle = vehicleDao.getVehicleById(vehicleId);
        this.repairedVehicle = repairedVehicle;
    }

    public void setRepairStatusById(int statusId) {
        StatusDao statusDao = new StatusDao();
        Status repairStatus = statusDao.getStatusById(statusId);
        this.repairStatus = repairStatus;
    }


}
