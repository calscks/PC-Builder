package app.pattern.strategy;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */
public class SocketCmp implements Compatibility {
    private String cpuSocket, moboSocket;

    /**
     * constructs the CPUSocket strategy to use as compatibility checker between CPU and Motherboard.
     * @param cpuSocket CPUSocket from CPU
     * @param moboSocket CPUSocket from Motherboard
     */
    public SocketCmp(String cpuSocket, String moboSocket) {
        this.cpuSocket = cpuSocket;
        this.moboSocket = moboSocket;
    }

    @Override
    public boolean isCompatible() {
        return cpuSocket.equalsIgnoreCase(moboSocket);
    }
}
