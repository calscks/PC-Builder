package app.control;

import app.model.Computer;
import app.pattern.strategy.Compatibility;
import app.pattern.strategy.CoolerMoboCmp;
import app.pattern.strategy.SocketCmp;
import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;

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

    public void initialize(){
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void call(){
        Compatibility compatibility;
        if (computer.getCpu() != null || !computer.getCpu().getType().equals("")
                && computer.getMobo() != null || !computer.getMobo().getType().equals("")){
            compatibility = new SocketCmp(computer.getCpu().getSize(), computer.getMobo().getType());
            if (compatibility.isCompatible())
                cmpCPUMobo.setText("Compatible");
            else
                cmpCPUMobo.setText("Incompatible");
        }

        if (!computer.getCooler().getType().equals("") && !computer.getMobo().getType().equals("")){
            compatibility = new CoolerMoboCmp(computer.getCooler().getType(), computer.getMobo().getType());
            if (compatibility.isCompatible())
                cmpCoolerMobo.setText("Compatible");
            else
                cmpCoolerMobo.setText("Incompatible");
        }
    }
}
