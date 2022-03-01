package lab01.tdd;

import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    private final List<Integer> list;
    private int head;

    public CircularListImpl(List<Integer> listImpl){
        this.list = listImpl;
        this.head = -1;
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        head++;
        if(head >= list.size()) {
            head = 0;
        }
        return Optional.of(list.get(head));
    }

    @Override
    public Optional<Integer> previous() {
        head--;
        if(head <= list.size()){
            head = 0;
        }
        return Optional.of(list.get(head));
    }

    @Override
    public void reset() {
        this.head = -1;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        var found = list.stream().anyMatch(strategy::apply);
        if(!found){
            return Optional.empty();
        }
        var element = next();
        while(!strategy.apply(element.get())){
            element = next();
        }
        return element;
    }
}
