package Pert.Catalin.Lab8.Ex4.Units;


import Pert.Catalin.Lab8.Ex4.Events.Event;
import Pert.Catalin.Lab8.Ex4.Events.FireEvent;
import Pert.Catalin.Lab8.Ex4.Events.TemperatureEvent;
import Pert.Catalin.Lab8.Ex4.Sensors.FireSensor;
import Pert.Catalin.Lab8.Ex4.Sensors.Sensor;
import Pert.Catalin.Lab8.Ex4.Sensors.TemperatureSensor;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ControlUnit extends Pert.Catalin.Lab8.Ex4.Home implements Unit {
    public static final Logger LOGGER = Logger.getLogger(ControlUnit.class);
    private final Unit heatingUnit = new HeatingUnit();
    private final Unit alarmUnit = new AlarmUnit();
    private final Unit coolingUnit = new CoolingUnit();
    private final Unit gsmUnit = new GsmUnit();
    public static final int PRESET_TEMP_VALUE = 22;
    private static ControlUnit instance;

    Sensor temperatureSensor = new TemperatureSensor();
    List<Sensor> fireSensors = new ArrayList<>();


    private ControlUnit() {
        for (int i = 0; i < 5; i++) {
            fireSensors.add(new FireSensor());
        }
    }

    public static ControlUnit getInstance() {
        if (instance == null) {
            instance = new ControlUnit();
        }
        return instance;
    }

    @Override
    protected void setValueInEnvironment(Event event) {
        switch (event.getType()) {
            case TEMPERATURE:
                this.temperatureSensor.setValue(((TemperatureEvent)event).getValue());
                break;
            case FIRE:
                this.fireSensors.get(rand.nextInt((fireSensors.size()))).setValue(((FireEvent)event).isSmoke() ? 1 : 0);
                break;
            case NONE:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + event.getType());
        }
    }

    @Override
    protected void controlStep() {
        LOGGER.info("Control step: ");
        fireSensors.stream()
                .filter(sensor -> sensor.getValue() == 1)
                .findAny()
                .ifPresent(sensor -> {
                    alarmUnit.execute();
                    gsmUnit.execute();
                });
        if (temperatureSensor.getValue() < PRESET_TEMP_VALUE) {
            heatingUnit.execute();
        } else {
            coolingUnit.execute();
        }
        LOGGER.info("");
        fireSensors.forEach(sensor -> sensor.setValue(0));
    }

    @Override
    public void execute() {
        super.simulate();
    }
}
