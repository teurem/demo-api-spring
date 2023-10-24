import java.util.Date;
import java.util.Objects;

public class Cars {
    private int id;
    private String brand;
    private String model;
    private Date year;
    private double cost;
    private double mileage; // пробег
    private String description;

    public Cars() {}

    public int getID()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", cost=" + cost +
                ", mileage=" + mileage +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return id == cars.id && Double.compare(cost, cars.cost) == 0 && Double.compare(mileage, cars.mileage) == 0 && Objects.equals(brand, cars.brand) && Objects.equals(model, cars.model) && Objects.equals(year, cars.year) && Objects.equals(description, cars.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, year, cost, mileage, description);
    }
}
