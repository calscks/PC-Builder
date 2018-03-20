package app.pattern.adapter;

import app.model.component.IComponent;
import app.model.peripheral.IMouse;
import app.model.peripheral.Mouse;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */
public class MouseAdapter implements IComponent {
    private IMouse mouse;

    public MouseAdapter(IMouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public String getName() {
        return mouse.getName();
    }

    @Override
    public String getType() {
        return String.valueOf(mouse.getDpi());
    }

    @Override
    public String getSize() {
        return mouse.getConnectionType();
    }

    @Override
    public BigDecimal getPrice() {
        return mouse.getPrice();
    }

    @Override
    public void setPrice(BigDecimal price) {
        mouse.setPrice(price);
    }
}
