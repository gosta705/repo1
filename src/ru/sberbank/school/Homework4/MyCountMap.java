package ru.sberbank.school.Homework4;

import java.util.HashMap;
import java.util.Map;

public class MyCountMap <T> implements CountMap <T> {

    private final Map<T, Integer> myMap;

    public MyCountMap() {
        myMap = new HashMap<>();
    }

    @Override
    public void add(T o) {
        myMap.put(o, myMap.containsKey(o) ? myMap.get(o) + 1 : 1);
    }

    @Override
    public int getCount(T o) {
        return myMap.get(o) == null ? 0 : myMap.get(o);
    }

    @Override
    public int remove(T o) {
        Integer result = myMap.remove(o);
        return result == null ? 0 : result;
    }

    @Override
    public int size() {
        return myMap.size();
    }

    private <T> void addToAnotherMap(Map <? extends T, Integer> source, Map <? super T, Integer> destination) {
        for (Map.Entry<? extends T, Integer> entry : source.entrySet()) {
            T key = entry.getKey();
            Integer value = entry.getValue();
            destination.put(key, destination.containsKey(key) ? destination.get(key) + value : value);
        }
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        addToAnotherMap(source.toMap(), myMap);
    }

    @Override
    public Map <T, Integer> toMap() {
        return myMap;
    }

    @Override
    public void toMap(Map <? super T, Integer> destination) {
        addToAnotherMap(myMap, destination);
    }

    public static void main(String[] args) {
        MyCountMap <Integer> map = new MyCountMap<>();

        map.add(5);
        map.add(5);
        map.add(5);
        map.add(6);
        map.add(6);
        map.add(7);

        System.out.println(map.getCount(5)); // 3
        System.out.println(map.getCount(6)); // 2
        System.out.println(map.getCount(7)); // 1

    }

}