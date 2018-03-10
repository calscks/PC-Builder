package app.model.component;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Seong Chee Ken on 11/03/2018.
 * Project Name: PC-Builder.
 * Cooler's type is reserved for its socketType. Therefore, actual cooler type will be inheriting the abstract cooler.
 */
public abstract class Cooler implements IComponent {
    ArrayList<String> socketType;
    float size;

    public abstract String getName();
    public String getType(){
        return String.join(";", socketType);
    }
    public String getSize(){
        return String.valueOf(size);
    }
    public abstract BigDecimal getPrice();
    public abstract void setPrice(BigDecimal price);
}
