package pl.qceyco.model;

public class Status {

    private int id;
    private String name;
    private int statusOrder;

    public Status() {
    }

    public Status(String name, int statusOrder) {
        this.name = name;
        this.statusOrder = statusOrder;
    }

    public Status(int id, String name, int statusOrder) {
        this.id = id;
        this.name = name;
        this.statusOrder = statusOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(int statusOrder) {
        this.statusOrder = statusOrder;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", statusOrder=" + statusOrder +
                '}';
    }
}
