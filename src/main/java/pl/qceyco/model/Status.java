package pl.qceyco.model;

public class Status {

    private int id;
    private boolean vehicleAccepted;
    private boolean costApproved;
    private boolean inRepair;
    private boolean repairComplete;
    private boolean resignation;

    public Status() {
    }

    public Status(boolean vehicleAccepted, boolean costApproved, boolean inRepair, boolean repairComplete, boolean resignation) {
        this.vehicleAccepted = vehicleAccepted;
        this.costApproved = costApproved;
        this.inRepair = inRepair;
        this.repairComplete = repairComplete;
        this.resignation = resignation;
    }

    public Status(int id, boolean vehicleAccepted, boolean costApproved, boolean inRepair, boolean repairComplete, boolean resignation) {
        this.id = id;
        this.vehicleAccepted = vehicleAccepted;
        this.costApproved = costApproved;
        this.inRepair = inRepair;
        this.repairComplete = repairComplete;
        this.resignation = resignation;
    }

    public boolean isInRepair() {
        return inRepair;
    }

    public void setInRepair(boolean inRepair) {
        this.inRepair = inRepair;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVehicleAccepted() {
        return vehicleAccepted;
    }

    public void setVehicleAccepted(boolean vehicleAccepted) {
        this.vehicleAccepted = vehicleAccepted;
    }

    public boolean isCostApproved() {
        return costApproved;
    }

    public void setCostApproved(boolean costApproved) {
        this.costApproved = costApproved;
    }

    public boolean isRepairComplete() {
        return repairComplete;
    }

    public void setRepairComplete(boolean repairComplete) {
        this.repairComplete = repairComplete;
    }

    public boolean isResignation() {
        return resignation;
    }

    public void setResignation(boolean resignation) {
        this.resignation = resignation;
    }
}
