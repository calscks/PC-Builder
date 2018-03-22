package app.pattern.absfact;

import app.model.component.IComponent;
import app.model.peripheral.Keyboard;
import app.model.peripheral.Mouse;
import app.pattern.adapter.KeyboardAdapter;
import app.pattern.adapter.MouseAdapter;
import app.utils.DBConnection;
import app.utils.EType;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seong Chee Ken on 12-Mar-18
 * Project name: PC-Builder
 */
public class PeripheralFactory implements AbsFactory<String> {
    private DBConnection connection;
    private String sql;

    public PeripheralFactory() {
        connection = DBConnection.getInstance();
    }

    @Override
    public IComponent createComponent(String component, String name, String type, String size, BigDecimal price) {
        if (component.equalsIgnoreCase("mouse"))
            return new MouseAdapter(new Mouse(name, Integer.parseInt(type), size, price));
        else if (component.equalsIgnoreCase("keyboard"))
            return new KeyboardAdapter(new Keyboard(name, type, size, price));
        throw new IllegalArgumentException("String component doesn't match anything.");
    }

    @Override
    public List<IComponent> createList(String component) throws SQLException {
        List<IComponent> list = new ArrayList<>();

        if (component.equalsIgnoreCase("mouse"))
            sql = "SELECT * FROM Mouse";
        else if (component.equalsIgnoreCase("keyboard"))
            sql = "SELECT * FROM Keyboard";
        else
            throw new IllegalArgumentException("component does not match anything.");

        ResultSet rs = connection.execute(EType.QUERY, sql);
        while (rs.next()){
            BigDecimal price = BigDecimal.valueOf(rs.getDouble(5));
            IComponent iComponent = createComponent(component, rs.getString(2), rs.getString(3), rs.getString(4), price);
            list.add(iComponent);
        }

        return list;
    }
}
