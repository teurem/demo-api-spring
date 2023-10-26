package org.example;

import models.Cars;

import java.util.*;
import java.sql.*;
import java.util.Date;

public class DBWorker {
    private static final String URL = "jdbc:postgresql://localhost:5432/CarsShop";
    private static final String login = "postgres";
    private static final String password = "pASSWORD123";

    public DBWorker()
    {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded sucsesful;");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Cars> getAllCars() {
        Connection connection = null;
        Statement statement = null;
        List<Cars> cars = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, login, password);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String brand = resultSet.getString(2);
                String model = resultSet.getString("model");
                Date date = resultSet.getDate(4);
                int cost = resultSet.getInt(5);
                String description = resultSet.getString(6);
                Cars car = new Cars(id, brand, model, date, cost, description);
                cars.add(car);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return cars;
    }

    public void drop()
    {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, login, password);
            statement = connection.createStatement();

            statement.execute("DELETE from cars");
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}

