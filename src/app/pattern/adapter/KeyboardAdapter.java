package app.pattern.adapter;

import app.model.component.IComponent;
import app.model.peripheral.IKeyboard;
import app.model.peripheral.Keyboard;

import java.math.BigDecimal;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */
public class KeyboardAdapter implements IComponent {
    private IKeyboard keyboard;

    public KeyboardAdapter(IKeyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public String getName() {
        return keyboard.getName();
    }

    @Override
    public String getType() {
        return keyboard.getKeyType();
    }

    @Override
    public String getSize() {
        return keyboard.getConnectionType();
    }

    @Override
    public BigDecimal getPrice() {
        return keyboard.getPrice();
    }

    @Override
    public void setPrice(BigDecimal price) {
        keyboard.setPrice(price);
    }
}
