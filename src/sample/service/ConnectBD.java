package sample.service;

public class ConnectBD {
    private String instanceName = "CHEBUREK\\SQLEXPRESS";
    private String databaseName = "Кафе";
    private String userName = "Misha";
    private String pass = "qwer200020002020";
    private String connectionUrl = "jdbc:sqlserver://%1$s;databaseName=%2$s;user=%3$s;password=%4$s;";
    private String connectionString = String.format(connectionUrl, instanceName, databaseName, userName, pass);

    public String getConnectionString() {
        return connectionString;
    }
}