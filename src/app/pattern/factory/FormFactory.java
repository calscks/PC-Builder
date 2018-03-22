package app.pattern.factory;

import app.model.component.EFormFactor;
import app.model.formfactor.*;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */
public class FormFactory {
    public static IFormFactor createFormFactor(EFormFactor formFactor){
        if (formFactor == EFormFactor.ATX)
            return new ATXFactor();
        else if (formFactor == EFormFactor.EATX)
            return new EATXFactor();
        else if (formFactor == EFormFactor.MATX)
            return new MATXFactor();
        else if (formFactor == EFormFactor.ITX)
            return new ITXFactor();
        throw new IllegalArgumentException("EFormFactor value is not recognised.");
    }
}
