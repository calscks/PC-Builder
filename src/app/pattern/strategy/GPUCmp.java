package app.pattern.strategy;

import app.model.component.GPU;
import app.model.component.IComponent;

/**
 * Created by Seong Chee Ken on 21/03/2018.
 * Project Name: PC-Builder.
 */
public class GPUCmp implements Compatibility {
    private GPU gpu;
    private int GPUCount;

    public GPUCmp(GPU gpu, int GPUCount) {
        this.gpu = gpu;
        this.GPUCount = GPUCount;
    }

    public GPUCmp(IComponent gpu, int GPUCount) {
        this.gpu = (GPU) gpu;
        if (!this.gpu.getType().equalsIgnoreCase("true") ||
                !this.gpu.getType().equalsIgnoreCase("false"))
            throw new IllegalArgumentException("IComponent inserted is not a valid GPU. It might be something else");
    }

    @Override
    public boolean isCompatible() {
        Boolean b = Boolean.parseBoolean(gpu.getType());
        return GPUCount > 0 && (b && GPUCount <= 4 || !b && GPUCount == 1);
    }
}
