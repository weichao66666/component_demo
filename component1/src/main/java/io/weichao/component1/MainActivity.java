package io.weichao.component1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.luojilab.component.componentlib.service.AutowiredService;
import com.luojilab.router.facade.annotation.Autowired;
import com.luojilab.router.facade.annotation.RouteNode;

@RouteNode(path = "/main", desc = "主页面")
public class MainActivity extends AppCompatActivity {
    @Autowired
    String arg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component1_activity_main);
        TextView tv = findViewById(R.id.textview);

        AutowiredService.Factory.getSingletonImpl().autowire(this);

        if (!TextUtils.isEmpty(arg)) {
            tv.setText(arg);
        }

        Intent intent = new Intent();
        intent.putExtra("callbackArg", "success");
        setResult(RESULT_OK, intent);
    }
}