package macro.runtimeChain;

public interface Chain {
    public void step();
    public int getCounter();
    public void addChainEntity(ChainEntity chainEntity);
}
