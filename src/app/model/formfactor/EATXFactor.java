package app.model.formfactor;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */
public class EATXFactor implements IFormFactor {


    @Override
    public int getRAMLimit() {
        return 8;
    }

    @Override
    public int getGPULimit() {
        return 4;
    }
}
