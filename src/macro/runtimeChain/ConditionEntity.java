package macro.runtimeChain;

import java.util.HashMap;
import java.util.function.Predicate;

public class ConditionEntity extends ChainEntity{
    private Predicate predicate;
    private ChainEntity trueCondition;
    private ChainEntity falseCondition;

    public ConditionEntity(Predicate predicate, ChainEntity trueCondition, ChainEntity falseCondition) {
        this.predicate = predicate;
        this.trueCondition = trueCondition;
        this.falseCondition = falseCondition;
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
        setNextEntity( predicate.test(this) ?  trueCondition : falseCondition);
    }
}
