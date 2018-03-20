package app.pattern.absfact;

import app.model.component.IComponent;
import app.model.software.ISoftware;
import app.model.software.Software;
import app.pattern.adapter.SoftwareAdapter;
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
public class SoftwareFactory implements AbsFactory<String>{

    private DBConnection connection;
    private String sql;

    public SoftwareFactory() {
        connection = DBConnection.getInstance();
    }

    @Override
    public IComponent createComponent(String component, String name, String type, String size, BigDecimal price) {
        ISoftware software = new Software(name, type, price);
        return new SoftwareAdapter(software);
    }

    @Override
    public List<IComponent> createList(String component) throws SQLException {
        List<IComponent> list = new ArrayList<>();
        if (component.equalsIgnoreCase("office"))
            sql = "SELECT * FROM Software WHERE type = 'office'";
        else if (component.equalsIgnoreCase("os"))
            sql = "SELECT * FROM Software WHERE type = 'os'";
        else if (component.equalsIgnoreCase("av"))
            sql = "SELECT * FROM Software WHERE type = 'av'";
        ResultSet rs = connection.execute(EType.QUERY, sql);
        while (rs.next()){
            BigDecimal price = BigDecimal.valueOf(rs.getDouble(4));
            ISoftware software = new Software(rs.getString(2), rs.getString(3), price);
            list.add(new SoftwareAdapter(software));
        }
        return list;
    }
}
