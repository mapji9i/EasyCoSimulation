package macro;

import macro.runtimeChain.Chain;

import static macro.Main.logger;

public class ChainStepper {
    Chain chain;
    private boolean cancelKey=true;
    private int limit=0;
    public ChainStepper(Chain chain) {
        this.chain = chain;
    }

    public void trimLimit(){
        this.limit=chain.getCounter();
    }

    public void incrementLimit(int delta){
        limit=(delta==Integer.MAX_VALUE)   ?   Integer.MAX_VALUE   :   limit+delta;
    }
    public void stop(){
        this.cancelKey=false;
    }

    public void run(){
        while (cancelKey){
            logger.sprint(limit+"");
            while (chain.getCounter()<limit){
                chain.step();
            }
        }
    }

}
