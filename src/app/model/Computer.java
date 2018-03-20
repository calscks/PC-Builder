package app.model;

import app.model.component.IComponent;
import app.model.peripheral.Keyboard;
import app.model.peripheral.Mouse;
import app.model.software.ISoftware;
import app.model.software.Software;

/**
 * Created by Seong Chee Ken on 19/03/2018.
 * Project Name: PC-Builder.
 * Big ass computer POJO
 */
public class Computer {
    private IComponent cpu, cooler, mobo, ram, gpu, psu, storage1, storage2, chassis, monitor;
    private ISoftware os, av, office;
    private Keyboard keyboard;
    private Mouse mouse;

    public Computer(IComponent cpu, IComponent cooler, IComponent mobo, IComponent ram, IComponent gpu, IComponent psu, IComponent storage1, IComponent storage2, IComponent chassis, IComponent monitor, ISoftware os, ISoftware av, ISoftware office, Keyboard keyboard, Mouse mouse) {
        this.cpu = cpu;
        this.cooler = cooler;
        this.mobo = mobo;
        this.ram = ram;
        this.gpu = gpu;
        this.psu = psu;
        this.storage1 = storage1;
        this.storage2 = storage2;
        this.chassis = chassis;
        this.monitor = monitor;
        this.os = os;
        this.av = av;
        this.office = office;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public Computer() {
    }

    public IComponent getCpu() {
        return cpu;
    }

    public void setCpu(IComponent cpu) {
        this.cpu = cpu;
    }

    public IComponent getCooler() {
        return cooler;
    }

    public void setCooler(IComponent cooler) {
        this.cooler = cooler;
    }

    public IComponent getMobo() {
        return mobo;
    }

    public void setMobo(IComponent mobo) {
        this.mobo = mobo;
    }

    public IComponent getRam() {
        return ram;
    }

    public void setRam(IComponent ram) {
        this.ram = ram;
    }

    public IComponent getGpu() {
        return gpu;
    }

    public void setGpu(IComponent gpu) {
        this.gpu = gpu;
    }

    public IComponent getPsu() {
        return psu;
    }

    public void setPsu(IComponent psu) {
        this.psu = psu;
    }

    public IComponent getStorage1() {
        return storage1;
    }

    public void setStorage1(IComponent storage1) {
        this.storage1 = storage1;
    }

    public IComponent getStorage2() {
        return storage2;
    }

    public void setStorage2(IComponent storage2) {
        this.storage2 = storage2;
    }

    public IComponent getChassis() {
        return chassis;
    }

    public void setChassis(IComponent chassis) {
        this.chassis = chassis;
    }

    public IComponent getMonitor() {
        return monitor;
    }

    public void setMonitor(IComponent monitor) {
        this.monitor = monitor;
    }

    public ISoftware getOs() {
        return os;
    }

    public void setOs(IComponent os) {
        this.os = new Software(os.getName(), os.getType(), os.getPrice());;
    }

    public ISoftware getAv() {
        return av;
    }

    public void setAv(IComponent av) {
        this.av = new Software(av.getName(), av.getType(), av.getPrice());
    }

    public ISoftware getOffice() {
        return office;
    }

    public void setOffice(IComponent office) {
        this.office = new Software(office.getName(), office.getType(), office.getPrice());
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(IComponent keyboard) {
        this.keyboard = new Keyboard(keyboard.getName(), keyboard.getType(), keyboard.getSize(), keyboard.getPrice());
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(IComponent mouse) {
        this.mouse = new Mouse(mouse.getName(), Integer.parseInt((mouse.getType().equals("")) ? "0" : mouse.getType()),
                mouse.getSize(), mouse.getPrice());
    }
}
