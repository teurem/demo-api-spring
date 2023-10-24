import java.util.Objects;

public class Details {
    private int id;
    private int idCar;
    private int idOrder;
    private int amount;
    private double priceForOne;

    public Details() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPriceForOne() {
        return priceForOne;
    }

    public void setPriceForOne(double priceForOne) {
        this.priceForOne = priceForOne;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", idCar=" + idCar +
                ", idOrder=" + idOrder +
                ", amount=" + amount +
                ", priceForOne=" + priceForOne +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Details)) return false;
        Details details = (Details) o;
        return getId() == details.getId() && getIdCar() == details.getIdCar() && getIdOrder() == details.getIdOrder() && getAmount() == details.getAmount() && Double.compare(getPriceForOne(), details.getPriceForOne()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIdCar(), getIdOrder(), getAmount(), getPriceForOne());
    }
}
