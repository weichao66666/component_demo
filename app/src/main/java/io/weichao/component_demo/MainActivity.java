package io.weichao.component_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;

import io.weichao.component_service.Component1Service;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bundleBtn = findViewById(R.id.btn_bundle);
        Button uriBtn = findViewById(R.id.btn_uri);
        Button callbackBtn = findViewById(R.id.btn_callback);
        bundleBtn.setOnClickListener(this);
        uriBtn.setOnClickListener(this);
        callbackBtn.setOnClickListener(this);

        Router router = Router.getInstance();
        if (router.getService(Component1Service.class.getSimpleName()) != null) {
            Component1Service service = (Component1Service) router.getService(Component1Service.class.getSimpleName());
            Toast.makeText(this, service.getComponentStr(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        String arg = "app arg";

        Bundle bundle = new Bundle();
        bundle.putString("arg", arg);

        final String URI_LEGAL = "DDComp://component1/main?arg=" + arg;

        switch (v.getId()) {
            case R.id.btn_bundle:
                UIRouter.getInstance().openUri(this, "DDComp://component1/main", bundle);
                break;
            case R.id.btn_uri:
                UIRouter.getInstance().openUri(this, URI_LEGAL, null);
                break;
            case R.id.btn_callback:
                UIRouter.getInstance().openUri(this, URI_LEGAL, null, 7777);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == 7777 && resultCode == RESULT_OK) {
                String callbackArg = data.getStringExtra("callbackArg");
                if (!TextUtils.isEmpty(callbackArg)) {
                    Toast.makeText(this, callbackArg, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}