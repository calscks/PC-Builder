package app.model.peripheral;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 12/03/2018.
 * Project Name: PC-Builder.
 */
public class Mouse implements IMouse {
    private String name;
    private int dpi;
    private String connectionType;
    private BigDecimal price;

    public Mouse(String name, int dpi, String connectionType, BigDecimal price) {
        this.name = name;
        this.dpi = dpi;
        this.connectionType = connectionType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getDpi() {
        return dpi;
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
