package app.pattern.strategy;
import app.model.component.EFormFactor;
import app.model.formfactor.IFormFactor;
import app.pattern.factory.FormFactory;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */
public class FormFactorCmp implements Compatibility {
    private int GPUCount, RAMCount;
    private String channelType;
    private EFormFactor formFactor;

    /**
     * constructs a strategy specifically for checking total selected
     * RAM count and GPU count.
     * @param GPUCount GPU count based on the number of selected GPU.
     * @param RAMCount RAM count based on the number of selected RAM.
     * @param channelType RAM's channel type.
     * @param formFactor Form Factor enum which should be returned from
     * {@link app.model.component.Mobo}'s {@code getSize()}.
     */
    public FormFactorCmp(int GPUCount, int RAMCount, String channelType, EFormFactor formFactor) {
        this.GPUCount = GPUCount;
        this.RAMCount = RAMCount;
        this.channelType = channelType;
        this.formFactor = formFactor;
    }

    @Override
    public boolean isCompatible() {
        //using FormFactory
        IFormFactor formFactorObj = FormFactory.createFormFactor(formFactor);
        if (channelType.equalsIgnoreCase("dual"))
            RAMCount *= 2;
        else if (channelType.equalsIgnoreCase("quad"))
            RAMCount *= 4;
        return formFactorObj.getGPULimit() >= GPUCount && formFactorObj.getRAMLimit() >= RAMCount;
    }
}
