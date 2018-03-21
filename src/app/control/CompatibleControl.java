package app.control;

import app.model.Computer;
import app.model.component.EFormFactor;
import app.model.component.IComponent;
import app.pattern.strategy.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import javafx.scene.control.Label;

import java.util.function.Supplier;

/**
 * Created by Seong Chee Ken on 20/03/2018.
 * Project Name: PC-Builder.
 */
public class CompatibleControl {
    public JFXButton close;
    public Label cmpCPUMobo;
    public Label cmpCoolerMobo;
    public Label cmpCoolerChs;
    public Label cmpNoGPU;
    public Label cmpNoMobo;
    public Label cmpMoboChs;
    private Computer computer;

    private IComponent cpu, mobo, cooler, ram, gpu, chassis;
    private int gpuCount, ramCount;

    // the dialog loaded with this controller and its binded fxml
    private JFXDialog thisDialogReference;

    public void initialize(){
        close.setOnMouseClicked(event -> thisDialogReference.close());
    }

    public void set(Computer computer, JFXDialog thisDialogReference) {
        this.computer = computer;
        cpu = computer.getCpu();
        mobo = computer.getMobo();
        cooler = computer.getCooler();
        ram = computer.getRam();
        gpu = computer.getGpu();
        chassis = computer.getChassis();
        gpuCount = computer.getGpuCount();
        ramCount = computer.getRamCount();
        this.thisDialogReference = thisDialogReference;
    }

    public void call(){

        compatibilityCheck(() -> !cpu.getType().equals("") && !mobo.getType().equals(""),
                CompType.CPUMobo, cmpCPUMobo);

        compatibilityCheck(() -> !cooler.getType().equals("") && !mobo.getType().equals(""),
                CompType.CoolerMobo, cmpCoolerMobo);

        compatibilityCheck(() -> !cooler.getType().equals("") && !chassis.getType().equals(""),
                CompType.CoolerChassis, cmpCoolerChs);

        compatibilityCheck(() -> !gpu.getType().equals(""),
                CompType.NumGPU, cmpNoGPU);

        compatibilityCheck(() -> !ram.getType().equals("") && !gpu.getType().equals("") && !mobo.getType().equals(""),
                CompType.RamGpuMobo, cmpNoMobo);

        compatibilityCheck(() -> !mobo.getType().equals("") && !chassis.getType().equals(""),
                CompType.MoboChassis, cmpMoboChs);
    }

    /**
     * Compatibility checker method which accepts the following:
     * @param booleanSupplier a function which receives nothing but returns a boolean,
     *                        which is the function inside the if clause's bracket.
     * @param compType {@link CompType} enumeration value.
     * @param labelToBeUpdated label which text shall be updated.
     */
    private void compatibilityCheck(Supplier<Boolean> booleanSupplier, CompType compType, Label labelToBeUpdated){
        Compatibility compatibility;
        if (booleanSupplier.get()){
            if (compType == CompType.CPUMobo)
                compatibility = new SocketCmp(cpu.getSize(), mobo.getType());
            else if (compType == CompType.CoolerMobo)
                compatibility = new CoolerMoboCmp(computer.getCooler().getType(), computer.getMobo().getType());
            else if (compType == CompType.CoolerChassis)
                compatibility = new DimensionCmp(cooler.getSize(), chassis.getSize());
            else if (compType == CompType.NumGPU)
                compatibility = new GPUCmp(gpu, gpuCount);
            else if (compType == CompType.RamGpuMobo)
                compatibility = new FormFactorCmp(gpuCount, ramCount, ram.getType(), EFormFactor.valueOf(mobo.getSize()));
            else if (compType == CompType.MoboChassis)
                compatibility = new MoboCaseCmp(mobo.getSize(), chassis.getType());
            else throw new IllegalArgumentException("CompType not recognised.");

            if (compatibility.isCompatible())
                labelToBeUpdated.setText("Compatible");
            else
                labelToBeUpdated.setText("Incompatible");
        }
    }

    private enum CompType{
        CPUMobo, CoolerMobo, CoolerChassis, NumGPU, RamGpuMobo, MoboChassis
    }
}
