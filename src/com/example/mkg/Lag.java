package com.example.mkg;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface Lag<K,V, T> {
    Map<K,V> compute(List<T> data);

}
