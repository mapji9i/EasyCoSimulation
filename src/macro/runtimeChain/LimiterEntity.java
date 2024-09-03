package macro.runtimeChain;

import macro.Logger;

import java.util.HashMap;

public class LimiterEntity extends ChainEntity {
    private final HashMap<String,Limit> limits = new HashMap<>();
    public LimiterEntity(Logger logger) {
        this.logger=logger;
    }

    public void addLimit(String parameterName, Limit limit){
        limits.put(parameterName,limit);
    }
    @Override
    protected void init() {

    }

    @Override
    protected void extract() {

    }

    @Override
    protected void run() {
        this.output=new HashMap<>();
        for(String parameter: input.keySet()){
            Double value = input.get(parameter);
            if(limits.containsKey(parameter)){
                Limit limit = limits.get(parameter);
                value=limit.cutIfAboveOrBelow(value);
            }
            output.put(parameter,value);
        }
        this.input=null;
    }

    public static class Limit{
        private final Double maxValue;
        private final Double minValue;

        public Limit(Double minValue, Double maxValue) {
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
        public Double cutIfAboveOrBelow(Double value){
            if (maxValue!=null && value > maxValue)
                return maxValue;
            if (minValue!=null && value < minValue)
                return  minValue;
            return value;
        }
    }
}
