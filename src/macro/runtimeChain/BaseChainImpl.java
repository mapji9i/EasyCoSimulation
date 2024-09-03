package macro.runtimeChain;

public class BaseChainImpl implements Chain {
    public ChainEntity firstChainEntity=null;
    public ChainEntity currentChainEntity=null;
    private int counter=0;

    public void addChainEntity(ChainEntity entity){
        if(entity!=null) {
            if(firstChainEntity==null) {
                firstChainEntity = entity;
                firstChainEntity.setNextEntity(firstChainEntity);
                currentChainEntity=firstChainEntity;
            }else {
                firstChainEntity.getPrevEntity().setNextEntity(entity);
                entity.setNextEntity(firstChainEntity);
            }
        }
    }

    @Override
    public void step() {
        do {
            currentChainEntity.execute();
            currentChainEntity = currentChainEntity.getNextEntity();
        }while(currentChainEntity!=firstChainEntity);
    }

    @Override
    public int getCounter() {
        return counter;
    }
}

