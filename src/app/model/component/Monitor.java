package app.model.component;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 12/03/2018.
 * Project Name: PC-Builder.
 */
public class Monitor implements IComponent {
    private String name, panelType;
    private double size;
    private BigDecimal price;

    public Monitor(String name, String panelType, double size, BigDecimal price) {
        this.name = name;
        this.panelType = panelType;
        this.size = size;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    // IPS, TN...
    @Override
    public String getType() {
        return panelType;
    }

    @Override
    public String getSize() {
        return size + "\"";
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
