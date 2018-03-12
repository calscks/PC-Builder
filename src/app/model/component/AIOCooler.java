package app.model.component;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 */
public class AIOCooler extends Cooler {
    private String name;
    private BigDecimal price;

    public AIOCooler(String name, ArrayList<String> socketType, float size, BigDecimal price) {
        this.name = name;
        this.socketType = socketType;
        this.size = size;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
