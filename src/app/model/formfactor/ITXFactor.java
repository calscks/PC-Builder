package app.model.formfactor;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */
public class ITXFactor implements IFormFactor {
    @Override
    public int getRAMLimit() {
        return 2;
    }

    @Override
    public int getGPULimit() {
        return 1;
    }
}
