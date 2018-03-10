package app.model.software;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 * Implementation of ISoftware. Software type can be os, anti-virus etc..
 * This class needs to adapt with IComponent
 */
public class Software implements ISoftware {
    private String name, swType;
    private BigDecimal price;

    public Software(String name, String swType, BigDecimal price) {
        this.name = name;
        this.swType = swType;
        this.price = price;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSwType() {
        return null;
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    public void setPrice(BigDecimal price) {

    }
}
