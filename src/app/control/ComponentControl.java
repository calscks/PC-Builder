package app.control;

import app.model.Computer;
import app.model.EComponent;
import app.model.component.IComponent;
import app.pattern.absfact.AbsFactory;
import app.pattern.absfact.ComponentFactory;
import app.pattern.absfact.PeripheralFactory;
import app.pattern.absfact.SoftwareFactory;
import app.utils.GenericBuilder;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.StringConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Seong Chee Ken on 19/03/2018.
 * Project Name: PC-Builder.
 */
public class ComponentControl {

    public StackPane baseStack;
    public StackPane secondStack;
    public JFXComboBox<IComponent> boxCPU;
    public JFXComboBox<IComponent> boxMobo;
    public JFXComboBox<IComponent> boxCooler;
    public JFXComboBox<IComponent> boxRAM;
    public JFXComboBox<IComponent> boxMonitor;
    public JFXComboBox<IComponent> boxCase;
    public JFXComboBox<IComponent> boxStorage1;
    public JFXComboBox<IComponent> boxStorage2;
    public JFXComboBox<IComponent> boxPSU;
    public JFXComboBox<IComponent> boxGPU;
    public JFXComboBox<Integer> boxRAMQuantity;
    public JFXComboBox<Integer> boxGPUQuantity;
    public Label priceCase;
    public Label priceStor1;
    public Label pricePSU;
    public Label priceCooler;
    public Label priceMobo;
    public Label priceCPU;
    public Label priceMonitor;
    public Label priceRAM;
    public Label priceGPU;
    public Label priceStor2;
    public JFXComboBox<IComponent> boxOS;
    public JFXComboBox<IComponent> boxOffice;
    public JFXComboBox<IComponent> boxAV;
    public Label priceAV;
    public Label priceOffice;
    public Label priceOS;
    public JFXComboBox<IComponent> boxMouse;
    public JFXComboBox<IComponent> boxKeyboard;
    public Label priceKB;
    public Label priceMouse;
    public JFXButton totalPrice;

    @SuppressWarnings("unchecked")
    public void initialize() throws SQLException {
        // A list of each combo box reference (and price list for label references)
        List<JFXComboBox<IComponent>> boxList = Arrays.asList(boxCPU, boxMobo, boxCooler, boxRAM, boxGPU,
                boxPSU, boxStorage1, boxStorage2, boxCase, boxMonitor,
                boxOS, boxOffice, boxAV, boxMouse, boxKeyboard);
        List<Label> priceList = Arrays.asList(priceCPU, priceMobo, priceCooler, priceRAM, priceGPU,
                pricePSU, priceStor1, priceStor2, priceCase, priceMonitor,
                priceOS, priceOffice, priceAV, priceMouse, priceKB);

        for (Label label : priceList) {
            label.setText("0.00");
        }

        totalPrice.setText("0.00");

        for (int i = 0; i < boxList.size(); i++) {
            JFXComboBox<IComponent> cb = boxList.get(i);
            cb.setConverter(new StringConverter<IComponent>() {
                @Override
                public String toString(IComponent object) {
                    return object.getName();
                }

                @Override
                public IComponent fromString(String string) {
                    return cb.getItems().stream().filter(component ->
                            component.getName().equals(string)).findFirst().orElse(null);
                }
            });

            int finalI = i;

            // modifies all price labels every time a combo box changes
            cb.valueProperty().addListener((observable, oldValue, newValue) ->
                    priceList.get(finalI).setText(
                            newValue
                                    .getPrice()
                                    .setScale(2, RoundingMode.HALF_UP)
                                    .toString()
                    )
            );

            cb.getItems().add(empty());
            cb.getSelectionModel().selectFirst();
        }

        /* Modifies the total price shown for total price button.
         * This means when a combo-box is selected and the price label is changed, value from
         * the price label will be reflected onto the total price.
         * */
        priceList.forEach(lb -> lb.textProperty().addListener((observable, oldValue, newValue) -> {

                    BigDecimal total = BigDecimal.valueOf(Double.parseDouble(totalPrice.getText()));
                    BigDecimal oldVal = BigDecimal.valueOf(Double.parseDouble(oldValue));
                    BigDecimal newVal = BigDecimal.valueOf(Double.parseDouble(newValue));

                    if (oldVal.compareTo(newVal) < 0)
                        total = total.add(newVal.subtract(oldVal));
                    else if (oldVal.compareTo(newVal) > 0)
                        total = total.subtract(oldVal.subtract(newVal));

                    totalPrice.setText(total.setScale(2, RoundingMode.HALF_UP).toString());
                }
        ));

        ObservableList<Integer> integers = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        Stream.of(boxGPUQuantity, boxRAMQuantity).forEach(cb -> {
            cb.setItems(integers);
            cb.getSelectionModel().selectFirst();
        });

        boxGPUQuantity.disableProperty().bind(boxGPU.valueProperty().isNull());
        boxRAMQuantity.disableProperty().bind(boxRAM.valueProperty().isNull());

        setQuantityListener(boxGPUQuantity, priceGPU);
        setQuantityListener(boxRAMQuantity, priceRAM);

        // usage of abstract factory
        AbsFactory factory = new ComponentFactory();

        boxCPU.getItems().addAll(factory.createList(EComponent.CPU));
        boxMobo.getItems().addAll(factory.createList(EComponent.MOBO));
        boxCooler.getItems().addAll(factory.createList(EComponent.AIRCOOLER));
        boxCooler.getItems().addAll(factory.createList(EComponent.AIOCOOLER));
        boxRAM.getItems().addAll(factory.createList(EComponent.RAM));
        boxMonitor.getItems().addAll(factory.createList(EComponent.MONITOR));
        boxCase.getItems().addAll(factory.createList(EComponent.CASE));
        boxStorage1.getItems().addAll(factory.createList(EComponent.STORAGE));
        boxStorage2.getItems().addAll(factory.createList(EComponent.STORAGE));
        boxPSU.getItems().addAll(factory.createList(EComponent.PSU));
        boxGPU.getItems().addAll(factory.createList(EComponent.GPU));

        // reusing factory with other factories
        factory = new SoftwareFactory();
        boxOS.getItems().addAll(factory.createList("os"));
        boxOffice.getItems().addAll(factory.createList("office"));
        boxAV.getItems().addAll(factory.createList("av"));

        factory = new PeripheralFactory();
        boxMouse.getItems().addAll(factory.createList("mouse"));
        boxKeyboard.getItems().addAll(factory.createList("keyboard"));

    }

    public Computer getComputer() {
        return GenericBuilder.of(Computer::new)
                .with(Computer::setCpu, boxCPU.getSelectionModel().getSelectedItem())
                .with(Computer::setMobo, boxMobo.getSelectionModel().getSelectedItem())
                .with(Computer::setCooler, boxCooler.getSelectionModel().getSelectedItem())
                .with(Computer::setRam, boxRAM.getSelectionModel().getSelectedItem())
                .with(Computer::setGpu, boxGPU.getSelectionModel().getSelectedItem())
                .with(Computer::setPsu, boxPSU.getSelectionModel().getSelectedItem())
                .with(Computer::setStorage1, boxStorage1.getSelectionModel().getSelectedItem())
                .with(Computer::setStorage2, boxStorage2.getSelectionModel().getSelectedItem())
                .with(Computer::setChassis, boxCase.getSelectionModel().getSelectedItem())
                .with(Computer::setMonitor, boxMonitor.getSelectionModel().getSelectedItem())
                .with(Computer::setOs, boxOS.getSelectionModel().getSelectedItem())
                .with(Computer::setOffice, boxOffice.getSelectionModel().getSelectedItem())
                .with(Computer::setAv, boxAV.getSelectionModel().getSelectedItem())
                .with(Computer::setMouse, boxMouse.getSelectionModel().getSelectedItem())
                .with(Computer::setKeyboard, boxKeyboard.getSelectionModel().getSelectedItem())
                .build();
    }

    /**
     * @return an empty anonymous IComponent.
     */
    private IComponent empty() {
        return new IComponent() {
            @Override
            public String getName() {
                return "(click to select)";
            }

            @Override
            public String getType() {
                return "";
            }

            @Override
            public String getSize() {
                return "";
            }

            @Override
            public BigDecimal getPrice() {
                return BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP);
            }

            @Override
            public void setPrice(BigDecimal price) {
            }
        };
    }

    private void setQuantityListener(JFXComboBox<Integer> comboBox, Label priceLabel){
        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            int i = comboBox.getSelectionModel().getSelectedItem();
            if (i > 0 && !priceLabel.getText().equals("0.00") && oldValue != null) {
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(priceLabel.getText()));
                price = price.divide(BigDecimal.valueOf(oldValue), 2, RoundingMode.HALF_UP);
                price = price.multiply(BigDecimal.valueOf(comboBox.getSelectionModel().getSelectedItem()));
                priceLabel.setText(price.setScale(2, RoundingMode.HALF_UP).toString());
            }
        });
    }
}
