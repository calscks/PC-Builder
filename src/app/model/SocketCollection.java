package app.model;

import app.pattern.iterator.SocketIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seong Chee Ken on 19/03/2018.
 * Project Name: PC-Builder.
 */
public class SocketCollection {
    private List<SocketType> sockets;

    public SocketCollection() {
        sockets = new ArrayList<>();
        sockets.add(new SocketType(Brand.INTEL, "LGA1151"));
        sockets.add(new SocketType(Brand.INTEL, "LGA2066"));
        sockets.add(new SocketType(Brand.AMD, "AM4"));
    }

    public void add(SocketType socket){
        sockets.add(socket);
    }

    public void remove(SocketType socket){
        sockets.remove(socket);
    }

    public SocketIterator iterator(Brand brand){
        return new SocketIterator(brand, sockets);
    }

    public SocketIterator iterator(String brand){
        Brand eBrand = Brand.valueOf(brand);
        return new SocketIterator(eBrand, sockets);
    }
}
