package lab01.tdd;

/**
 * A concrete factory for an {@link EvenSelectStrategy}
 */
public class EvenSelectStrategyFactory implements SelectStrategyFactory{
    @Override
    public SelectStrategy createSelectStrategy() {
        return new EvenSelectStrategy();
    }
}
