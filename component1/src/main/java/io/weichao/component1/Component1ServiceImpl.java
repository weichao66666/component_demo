package io.weichao.component1;

import io.weichao.component_service.Component1Service;

public class Component1ServiceImpl implements Component1Service {
    @Override
    public String getComponentStr() {
        return "component1";
    }
}