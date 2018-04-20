package io.weichao.component1;

import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.router.Router;

import io.weichao.component_service.Component1Service;

public class Component1ApplicationLike implements IApplicationLike {
    Router router = Router.getInstance();
    @Override
    public void onCreate() {
        router.addService(Component1Service.class.getSimpleName(), new Component1ServiceImpl());
    }

    @Override
    public void onStop() {
        router.removeService(Component1Service.class.getSimpleName());
    }
}