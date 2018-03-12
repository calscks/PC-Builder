package app.model.component;

import app.model.CaseType;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 12/03/2018.
 * Project Name: PC-Builder.
 */
public class Case implements IComponent {
    private String name;
    private CaseType caseType;
    private int clearance;
    private BigDecimal price;

    public Case(String name, CaseType caseType, int clearance, BigDecimal price) {
        this.name = name;
        this.caseType = caseType;
        this.clearance = clearance;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return caseType.name();
    }

    @Override
    public String getSize() {
        return clearance + "mm";
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
