package app.pattern.absfact;

import app.model.EComponent;
import app.model.component.IComponent;

import java.util.List;
import java.util.Map;

/**
 * Created by Seong Chee Ken on 12-Mar-18
 * Project name: PC-Builder
 */
public class ComponentFactory implements AbsFactory<EComponent> {
    private Map<EComponent, List<IComponent>> componentListMap;

    public ComponentFactory(Map<EComponent, List<IComponent>> componentListMap) {
        this.componentListMap = componentListMap;
    }

    /**
     *
     * @param component {@link EComponent} enumeration.
     * @param index index gotten from the combo-box's arrayList.
     * @return ? implements {@link IComponent}.
     */
    @Override
    public IComponent createComponent(EComponent component, int index) {
        return componentListMap.get(component).get(index);
    }
}
