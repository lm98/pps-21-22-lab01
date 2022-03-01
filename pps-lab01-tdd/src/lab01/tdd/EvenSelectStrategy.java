package lab01.tdd;

/**
 * A {@link SelectStrategy} that selects even integer numbers
 */
public class EvenSelectStrategy implements SelectStrategy{
    @Override
    public boolean apply(int element) {
        return element%2==0;
    }
}
