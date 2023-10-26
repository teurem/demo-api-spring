package models;

import java.util.Date;
import java.util.Objects;

public class Orders {
    private int id;
    private Date date;
    private double summa;
    private String status;
    private int idClient;

    public Orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "models.Orders{" +
                "id=" + id +
                ", date=" + date +
                ", summa=" + summa +
                ", status='" + status + '\'' +
                ", idClient=" + idClient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && Double.compare(summa, orders.summa) == 0 && idClient == orders.idClient && Objects.equals(date, orders.date) && Objects.equals(status, orders.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, summa, status, idClient);
    }
}
