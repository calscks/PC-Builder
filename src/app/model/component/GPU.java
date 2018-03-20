package app.model.component;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 */
public class GPU implements IComponent {
    private String name;
    private boolean multiGPU;
    private int size;
    private BigDecimal price;

    public GPU(String name, boolean multiGPU, int size, BigDecimal price) {
        this.name = name;
        this.multiGPU = multiGPU;
        this.size = size;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return String.valueOf(multiGPU);
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
