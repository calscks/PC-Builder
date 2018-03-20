package app.pattern.strategy;

import app.model.CaseType;
import app.model.component.EFormFactor;

/**
 * Created by Seong Chee Ken on 15/03/2018.
 * Project Name: PC-Builder.
 */
public class MoboCaseCmp implements Compatibility {
    private EFormFactor moboFactor;
    private CaseType caseType;

    public MoboCaseCmp(EFormFactor moboFactor, CaseType caseType) {
        this.moboFactor = moboFactor;
        this.caseType = caseType;
    }

    public MoboCaseCmp(String moboFactor, String caseType) {
        this.moboFactor = EFormFactor.valueOf(moboFactor.toUpperCase());
        this.caseType = CaseType.valueOf(caseType.toUpperCase());
    }

    @Override
    public boolean isCompatible() {
        if (caseType == CaseType.FULLTOWER)
            return true;
        else if (caseType == CaseType.MIDTOWER){
            return moboFactor != EFormFactor.EATX;
        } else if (caseType == CaseType.SFF){
            return moboFactor == EFormFactor.ITX || moboFactor == EFormFactor.MATX;
        }
        return false;
    }
}
