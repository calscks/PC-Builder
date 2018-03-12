package app.pattern.absfact;

import app.model.component.IComponent;

/**
 * Created by Seong Chee Ken on 12/03/2018.
 * Project Name: PC-Builder.
 */
public interface AbsFactory<T> {
    IComponent createComponent(T component, int index);
}
