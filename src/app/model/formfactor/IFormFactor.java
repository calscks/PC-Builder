package app.model.formfactor;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */

public interface IFormFactor {

    int getRAMLimit();
    int getGPULimit();

    default int getCPULimit(){
        return 1;
    }
}
