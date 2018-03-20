package app.model.component;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 */
public class CPU implements IComponent {
    private String name, family, socketType;
    private BigDecimal price;

    public CPU(String name, String family, String socketType, BigDecimal price) {
        this.name = name;
        this.family = family;
        this.socketType = socketType;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    // family means architecture
    @Override
    public String getType() {
        return family;
    }

    // size of CPU is equivalent to socket
    @Override
    public final String getSize() {
        return socketType;
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
