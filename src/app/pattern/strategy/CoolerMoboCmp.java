package app.pattern.strategy;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */
public class CoolerMoboCmp implements Compatibility {
    private String socketTypes, moboSocket;

    public CoolerMoboCmp(String socketTypes, String moboSocket) {
        this.socketTypes = socketTypes;
        this.moboSocket = moboSocket;
    }

    @Override
    public boolean isCompatible() {
        return socketTypes.toLowerCase().contains(moboSocket.toLowerCase());
    }
}
