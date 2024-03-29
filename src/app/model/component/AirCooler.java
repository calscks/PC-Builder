package app.model.component;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 */
public class AirCooler extends Cooler {
    private String name;
    private BigDecimal price;

    public AirCooler(String name, ArrayList<String> socketType, float size, BigDecimal price) {
        this.name = name;
        this.socketType = socketType;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
