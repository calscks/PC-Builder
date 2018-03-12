package app.model.component;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 */
public class PSU implements IComponent {
    private String name, size, type;
    private BigDecimal price;

    public PSU(String name, String size, String type, BigDecimal price) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    // SFX, ATX
    @Override
    public String getSize() {
        return size;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
