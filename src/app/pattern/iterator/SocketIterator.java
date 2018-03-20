package app.pattern.iterator;

import app.model.Brand;
import app.model.SocketType;

import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Seong Chee Ken on 16/03/2018.
 * Project Name: PC-Builder.
 */
public class SocketIterator implements Iterator {
    private Brand brand;
    private List<SocketType> sockets;
    private int index;

    public SocketIterator(Brand brand, List<SocketType> sockets) {
        this.brand = brand;
        this.sockets = sockets;
    }

    @Override
    public boolean hasNext() {
        while (index < sockets.size()){

            SocketType socket = sockets.get(index);

            if (brand == Brand.ALL)
                return true;

            if (socket.getBrand().equals(brand))
                return true;
            else
                index++;
        }
        return false;
    }

    @Override
    public SocketType next() {
        SocketType socket = sockets.get(index);
        index++;
        return socket;
    }
}
