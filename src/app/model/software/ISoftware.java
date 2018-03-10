package app.model.software;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 */
public interface ISoftware {
    String getName();
    String getSwType();
    BigDecimal getPrice();
    void setPrice(BigDecimal price);
}
