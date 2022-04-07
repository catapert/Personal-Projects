package Pert.Catalin.Lab8.Ex4.Units;

import org.apache.log4j.Logger;

public class HeatingUnit implements Unit {
    private static final Logger LOGGER = Logger.getLogger(AlarmUnit.class);
    @Override
    public void execute() {
        LOGGER.info("Start heating!");
    }
}
