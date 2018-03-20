package app.model.software;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 * Implementation of ISoftware. Software type can be os, anti-virus etc..
 * This class needs to adapt with IComponent
 */
public class Software implements ISoftware {
    private String name, category;
    private BigDecimal price;

    public Software(String name, String category, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSwCategory() {
        return category;
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
