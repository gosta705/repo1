import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by tanya on 19.10.2016.
 */
public class Stream <T> {
    private final List<T> collection;


    private Stream(List<T> collection){
        this.collection = collection;
    }

    public static <T> Stream<T> of(List<T> list) {
        List<T> collection = new ArrayList<>();
        collection.addAll(list);
        return new Stream<>(collection);

    }

    public Stream filter(Predicate<? super T> predicate){
        List<T> result = new ArrayList<>();
        for (T t : collection) {
            if(predicate.test(t)) result.add(t);
        }
        return Stream.of(result);
        //return this;
    }

    public <R> Stream<R> transform(Function<? super T, ? extends R> fun) {
        List<R> result = new ArrayList<>();
        for (T t : collection) {
            result.add(fun.apply(t));
        }
        return Stream.of(result);
    }

    public <K, V> Map<K,V> toMap(Function<? super T, ? extends K> fun1, Function<? super T, ? extends V> fun2) {
        Map<K,V> result = new HashMap<>();
        for (T t : collection) {
            result.put(fun1.apply(t), fun2.apply(t));
        }
        return result;
    }
}
