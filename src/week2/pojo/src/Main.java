public class Main {

    public static void main(String[] args)
    {
        try{
            Class.forName("com.postgresql.jdbc.driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
