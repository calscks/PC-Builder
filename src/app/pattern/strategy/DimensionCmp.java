package app.pattern.strategy;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */
public class DimensionCmp implements Compatibility {

    private double coolerHeight, clearance;

    public DimensionCmp(double coolerHeight, double clearance) {
        this.coolerHeight = coolerHeight;
        this.clearance = clearance;
    }

    public DimensionCmp(String coolerHeight, String clearance) {
        this.coolerHeight = Double.parseDouble(coolerHeight);
        this.clearance = Double.parseDouble(clearance);
    }

    @Override
    public boolean isCompatible() {
        return coolerHeight <= clearance;
    }
}
