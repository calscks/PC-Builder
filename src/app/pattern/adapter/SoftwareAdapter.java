package app.pattern.adapter;

import app.model.component.IComponent;
import app.model.software.ISoftware;
import app.model.software.Software;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */
public class SoftwareAdapter implements IComponent {
    private ISoftware software;

    public SoftwareAdapter(ISoftware software) {
        this.software = software;
    }

    @Override
    public String getName() {
        return software.getName();
    }

    @Override
    public String getType() {
        return software.getSwCategory();
    }

    @Override
    public String getSize() {
        throw new UnsupportedOperationException("getSize for software is unsupported.");
    }

    @Override
    public BigDecimal getPrice() {
        return software.getPrice();
    }

    @Override
    public void setPrice(BigDecimal price) {
        software.setPrice(price);
    }
}
