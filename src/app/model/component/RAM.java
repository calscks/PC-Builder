package app.model.component;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 */
public class RAM implements IComponent{
    private String name, channelType;
    private int size;
    private BigDecimal price;

    public RAM(String name, String channelType, int size, BigDecimal price) {
        this.name = name;
        this.channelType = channelType;
        this.size = size;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return channelType;
    }

    @Override
    public String getSize() {
        return size + "GB";
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
