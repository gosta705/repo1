package ru.sberbank.school.Homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class CollectionUtils {

    public static <E> void addAll(List<? extends E> source, List<? super E> destination) {
        destination.addAll(source);
    }


    public static <E> List<E> newArrayList() {
        return new ArrayList<>();
    }


    public static <E> int indexOf(List<? super E> source, E o) {
        return source.indexOf(o);
    }


    public static <E> List<E> limit(List<E> source, int size) {
        return source.subList(0, size);
    }


    public static <E> void add(List<? super E> source, E o) {
        source.add(o);
    }


    public static <E> void removeAll(List<? super E> removeFrom, List<? extends E> removeWhat) {
        removeFrom.removeAll(removeWhat);
    }

    public static <E> boolean containsAll(List<? super E> containsWhere, List<? extends E> containsWhat) {
        return containsWhere.containsAll(containsWhat);
    }

    public static <E> boolean containsAny(List<? super E> containsWhere, List<? extends E> containsWhat) {
        for (E o : containsWhat) {
            if (containsWhere.contains(o)) {
                return true;
            }
        }
        return false;
    }

    public static <E extends Comparable<? super E>> List<E> range(List<? extends E> list, E min, E max) {
        List<E> result = new ArrayList<>(list);
        Collections.sort(result);
        if (result.isEmpty()) {
            return result;
        }
        int minIndex = 0;
        int maxIndex = 0;
        for (E e : result) {
            if (e.compareTo(min) >= 0) {
                minIndex = result.indexOf(e);
                break;
            }
        }
        for (int i = result.size() - 1; i > -1; i--) {
            if (result.get(i).compareTo(max) <= 0) {
                maxIndex = i + 1;
                break;
            }
        }
        return result.subList(minIndex, maxIndex);
    }

    public static <E> List<E> range(List<? extends E> source, E min, E max, Comparator<? super E> comparator) {
        List<E> result = new ArrayList<>(source);
        result.sort(comparator);
        if (result.isEmpty()) {
            return result;
        }
        int minIndex = 0;
        int maxIndex = 0;
        for (E e : result) {
            if (comparator.compare(e, min) >= 0) {
                minIndex = result.indexOf(e);
                break;
            }
        }
        for (int i = result.size() - 1; i > -1; i--) {
            if (comparator.compare(result.get(i), max) <= 0) {
                maxIndex = i + 1;
                break;
            }
        }
        return result.subList(minIndex, maxIndex);
    }
}