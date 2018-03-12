package app.model.component;

import app.model.FormFactor;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 */
public class Mobo implements IComponent {
    private String name, socketType;
    private FormFactor formFactor; //this is not IFormFactor, this is an enum type
    private BigDecimal price;

    public Mobo(String name, String socketType, FormFactor formFactor, BigDecimal price) {
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
