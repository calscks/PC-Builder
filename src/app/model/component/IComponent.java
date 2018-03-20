package app.model.component;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 */
public interface IComponent extends Cloneable {
    String getName();
    String getType();
    String getSize();
    BigDecimal getPrice();
    void setPrice(BigDecimal price);
}
