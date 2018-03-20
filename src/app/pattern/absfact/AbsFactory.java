package app.pattern.absfact;

import app.model.component.IComponent;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Seong Chee Ken on 12/03/2018.
 * Project Name: PC-Builder.
 */
public interface AbsFactory<T> {
    IComponent createComponent(T component, String name, String type, String size, BigDecimal price);
    List<IComponent> createList(T component) throws SQLException;
}
