package lab01.tdd;

/**
 * A generic Factory for a {@link SelectStrategy}
 */
public interface SelectStrategyFactory {
    /**
     *
     * @return a concrete {@link SelectStrategy}
     */
    SelectStrategy createSelectStrategy();
}
