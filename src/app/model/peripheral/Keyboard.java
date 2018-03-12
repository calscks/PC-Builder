package app.model.peripheral;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 12/03/2018.
 * Project Name: PC-Builder.
 */
public class Keyboard {
    private String name, keyType, connectionType;
    private BigDecimal price;

    public Keyboard(String name, String keyType, String connectionType, BigDecimal price) {
        this.name = name;
        this.keyType = keyType;
        this.connectionType = connectionType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getKeyType() {
        return keyType;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
