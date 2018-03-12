package app.model.component;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 */
public class Storage implements IComponent {
    private String name, type;
    private int capacity;
    private BigDecimal price;

    /**
     * @param name name of the HDD/SSHD/SSD
     * @param type HDD/SSHD/SSD etc
     * @param capacity in Gigabyte
     * @param price price of the storage device
     */
    public Storage(String name, String type, int capacity, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    // remember, 1TB = 1000GB is standardised for disk drive manufacturers
    @Override
    public String getSize() {
        if (capacity < 1000 && capacity > 0)
            return capacity + "GB";
        else if (capacity >= 1000) {
            double rounded = capacity / 1000;
            return rounded + "TB";
        }
        throw new IllegalArgumentException("Capacity out of bound. Make sure you've entered the correct capacity.");
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
