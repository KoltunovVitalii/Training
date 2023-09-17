package ru.mfti.koltunov.database;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private String data = "Hi guys";
    List<Connection> connectionList = new ArrayList<>();
    int countConnections = 5;

    Connection getConnection() {
        if (connectionList.size() >= countConnections) {
            throw new RuntimeException("no avaliable connection");
        }
        Connection connection = new Connection();
        connectionList.add(connection);
        return connection;
    }

    public class Connection {
        private boolean isOpen = true;

        private Connection() {
        }

        String getData() {
            if (!isOpen) {
                throw new RuntimeException("Conntction is close");
            }
            return data;
        }

        public void close() {
            connectionList.remove(this);
            isOpen = false;
        }
    }


}
