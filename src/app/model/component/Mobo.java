package app.model.component;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 */
public class Mobo implements IComponent {
    private String name, socketType;
    private EFormFactor formFactor; //this is not FormFactor class, this is an enum
    private BigDecimal price;

    public Mobo(String name, String socketType, EFormFactor formFactor, BigDecimal price) {
        this.name = name;
        this.socketType = socketType;
        this.formFactor = formFactor;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return socketType;
    }

    @Override
    public String getSize() {
        return formFactor.name();
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
