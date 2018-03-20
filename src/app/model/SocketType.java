package app.model;

/**
 * Created by Seong Chee Ken on 19/03/2018.
 * Project Name: PC-Builder.
 */
public class SocketType {
    private Brand brand;
    private String socketName;

    public SocketType(Brand brand, String socketName) {
        this.brand = brand;
        this.socketName = socketName;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getSocketName() {
        return socketName;
    }
}
