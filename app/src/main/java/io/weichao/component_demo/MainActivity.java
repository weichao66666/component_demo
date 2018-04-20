package io.weichao.component_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.luojilab.component.componentlib.router.Router;

import io.weichao.component_service.Component1Service;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Router router = Router.getInstance();
        if (router.getService(Component1Service.class.getSimpleName()) != null) {
            Component1Service service = (Component1Service) router.getService(Component1Service.class.getSimpleName());
            Toast.makeText(this, service.getComponentStr(), Toast.LENGTH_LONG).show();
        }
    }
}