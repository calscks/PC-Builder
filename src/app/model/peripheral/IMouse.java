package app.model.peripheral;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 20/03/2018.
 * Project Name: PC-Builder.
 */
public interface IMouse {
    String getName();
    int getDpi();
    String getConnectionType();
    BigDecimal getPrice();
    void setPrice(BigDecimal price);
}
