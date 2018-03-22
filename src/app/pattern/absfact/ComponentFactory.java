package app.pattern.absfact;

import app.model.CaseType;
import app.model.EComponent;
import app.model.SocketCollection;
import app.model.SocketType;
import app.model.component.*;
import app.pattern.iterator.SocketIterator;
import app.utils.DBConnection;
import app.utils.EType;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Seong Chee Ken on 12-Mar-18
 * Project name: PC-Builder
 */
public class ComponentFactory implements AbsFactory<EComponent> {

    private String sql;
    private SocketCollection socketCollection = new SocketCollection();
    private DBConnection connection;
    
    public ComponentFactory(){
        connection = DBConnection.getInstance();
    }

    // creates an IComponent based on the EComponent enumeration value
    @Override
    public IComponent createComponent(EComponent component, String name, String type, String size, BigDecimal price) {
        if (component == EComponent.CPU)
            return new CPU(name, type, size, price);
        else if (component == EComponent.AIRCOOLER) {
            SocketIterator iterator = socketCollection.iterator(type);
            ArrayList<String> sockets = new ArrayList<>();
            while (iterator.hasNext()){
                sockets.add(iterator.next().getSocketName());
            }
            return new AirCooler(name, sockets, Float.parseFloat(size), price);
        }
        else if (component == EComponent.AIOCOOLER) {
            SocketIterator iterator = socketCollection.iterator(type);
            ArrayList<String> sockets = new ArrayList<>();
            while (iterator.hasNext()){
                sockets.add(iterator.next().getSocketName());
            }
            return new AIOCooler(name, sockets, Float.parseFloat(size), price);
        }
        else if (component == EComponent.MOBO) {
            EFormFactor formFactor = EFormFactor.valueOf(size);
            return new Mobo(name, type, formFactor, price);
        }
        else if (component == EComponent.RAM)
            return new RAM(name, type, Integer.parseInt(size), price);
        else if (component == EComponent.GPU)
            return new GPU(name, Boolean.parseBoolean(type), Integer.parseInt(size), price);
        else if (component == EComponent.PSU)
            return new PSU(name, size, type, price);
        else if (component == EComponent.STORAGE)
            return new Storage(name, type, Integer.parseInt(size), price);
        else if (component == EComponent.CASE) {
            CaseType caseType = CaseType.valueOf(type);
            return new Case(name, caseType, Integer.parseInt(size), price);
        }
        else if (component == EComponent.MONITOR)
            return new Monitor(name, type, size, price);
        return null;
    }

    //language=SQLite
    public List<IComponent> createList(EComponent component) throws SQLException {
        List<IComponent> list = new ArrayList<>();
        if (component == EComponent.CPU)
            sql = "SELECT * FROM CPU";
        else if (component == EComponent.AIRCOOLER)
            sql = "SELECT * FROM AirCooler";
        else if (component == EComponent.AIOCOOLER)
            sql = "SELECT * FROM AIOCooler";
        else if (component == EComponent.MOBO)
            sql = "SELECT * FROM Mobo";
        else if (component == EComponent.RAM)
            sql = "SELECT * FROM RAM";
        else if (component == EComponent.GPU)
            sql = "SELECT * FROM GPU";
        else if (component == EComponent.PSU)
            sql = "SELECT * FROM PSU";
        else if (component == EComponent.STORAGE)
            sql = "SELECT * FROM Storage";
        else if (component == EComponent.CASE)
            sql = "SELECT * FROM Chassis";
        else if (component == EComponent.MONITOR)
            sql = "SELECT * FROM Monitor";

        ResultSet resultSet = connection.execute(EType.QUERY, sql);

        while (resultSet.next()){
            BigDecimal price = BigDecimal.valueOf(resultSet.getDouble(5));

            IComponent iComponent = createComponent(component,
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    price);

            list.add(iComponent);
        }

        return list;
    }
}
