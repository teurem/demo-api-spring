package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;

import models.Cars;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/CarsShop";
    private static final String login = "postgres";
    private static final String password = "pASSWORD123";

  //  private static final String INSERT_NEW = "INSERT INTO cars(id, brand, model, year, cost, description)" + "VALUES (?,?,?,?,?,?)";

    public static void main(String[] args) {

        DBWorker dbWorker = new DBWorker();
        List<Cars> cars = dbWorker.getAllCars();

        for (Cars car : cars) {
            System.out.println(car.getID() + " " + car.getBrand() + " " + car.getModel() + " " + car.getYear() + " " +
                    car.getCost() + " " + car.getDescription());
        }

        //при удалении
        //   dbWorker.drop();

        //добавить запись в таблицу
        registerDriver();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, login, password);
            statement = connection.createStatement();

            statement.execute("INSERT INTO cars(id, brand, model, year, cost, description) VALUES (1, 'Subaru', 'Legacy', '2005-01-01', 7600, 'не бита, не крашена')");

            boolean closed = statement.isClosed();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded sucsesful;");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }

        try {
            connection =  DriverManager.getConnection(URL, login, password);

            if (!connection.isClosed()) {
                System.out.println("Correct connection to db!");
            }

            connection.close();

            if (connection.isClosed())
            {
                System.out.println("ConnectionJDBC closed: (");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void registerDriver() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded sucsesful;");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
    }
}