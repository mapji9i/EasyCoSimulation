package macro.runtimeChain;

import macro.Logger;

import java.util.Random;


public class RandomNumberEntity extends ChainEntity{
    private String keyInOutput;

    public RandomNumberEntity(Logger logger, String keyInOutput) {
        this.keyInOutput = keyInOutput;
        this.logger=logger;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void extract() {
        this.output.putAll(this.input);
    }

    @Override
    protected void run() {
        Double value=Math.random()*(10);
        this.output.put(keyInOutput, value);
        logger.print(String.format("%6.3f",value));
    }
}
