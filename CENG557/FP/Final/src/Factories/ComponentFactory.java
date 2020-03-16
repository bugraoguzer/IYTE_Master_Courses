package Factories;

import Application.Feature;

public class ComponentFactory {

    public static Feature get(AbstractFactory factory,String Component){
        return factory.CreateComponent(Component);
    }
}
