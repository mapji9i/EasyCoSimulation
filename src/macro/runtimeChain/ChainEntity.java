package macro.runtimeChain;

import macro.Logger;

import java.util.HashMap;

public abstract class ChainEntity {
    private ChainEntity nextEntity;
    private ChainEntity prevEntity;
    protected Logger logger;

    public HashMap<String, Double> getInput() {
        return input;
    }

    public HashMap<String, Double> getOutput() {
        return output;
    }



    protected HashMap<String, Double> input;
    protected HashMap<String, Double> output;



    public ChainEntity getNextEntity(){
        return nextEntity;
    }

    public ChainEntity getPrevEntity() {
        return prevEntity;
    }

    public void setNextEntity(ChainEntity nextEntity) {
        if(nextEntity!=null) {
            this.nextEntity = nextEntity;
            nextEntity.setPrevEntity(this);
        }
    }

    private void setPrevEntity(ChainEntity prevEntity) {
        if(prevEntity!=null) {
            this.prevEntity = prevEntity;
        }
    }

    protected abstract void init();

    protected abstract void extract();



    private void recieve(){
        this.getNextEntity().input=this.output;
        this.output=null;

    }

    protected abstract void run();

    public void execute(){
        createInputOutputIfNotExist();
        init();
        run();
        extract();
        recieve();
    }

    private void createInputOutputIfNotExist(){
        if(this.input==null) this.input=new HashMap<>();
        if(this.output==null) this.output=new HashMap<>();
    }


}
