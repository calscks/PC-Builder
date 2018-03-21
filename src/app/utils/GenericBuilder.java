package app.utils;

import javafx.util.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by Seong Chee Ken on 20/03/2018.
 * Project Name: PC-Builder.
 * Generic builder which accepts any type of object.
 */
public class GenericBuilder<T> implements Builder<T> {

    private final Supplier<T> instantiator;

    private List<Consumer<T>> instanceModifiers = new ArrayList<>();

    public GenericBuilder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    /**
     * @param instantiator a new T object, calling through its constructor
     * @param <T> generic T type
     * @return a new Builder carrying generic T type
     */
    public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
        return new GenericBuilder<>(instantiator);
    }

    /**
     * calls to add a value to the member of T.
     * @param consumer any setter within T object, through method referencing.
     * @param value set a value to the setter.
     * @param <U> type of the setter value.
     * @return this builder
     */
    public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
        Consumer<T> c = instance -> consumer.accept(instance, value);
        instanceModifiers.add(c);
        return this;
    }

    @Override
    public T build() {
        T value = instantiator.get();
        instanceModifiers.forEach(modifier -> modifier.accept(value));
        instanceModifiers.clear();
        return value;
    }
}
