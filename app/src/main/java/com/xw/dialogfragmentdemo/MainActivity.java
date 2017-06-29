package com.xw.dialogfragmentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginDialogFragment.LoginInputListener {

    private Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = (Button) findViewById(R.id.show);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginDialogFragment dialog = new LoginDialogFragment();
                dialog.show(getFragmentManager(), "loginDialog");
            }
        });
    }

    /**
     * 获取dialog点击回调值
     * @param username
     * @param password
     */
    @Override
    public void onLoginInputComplete(String username, String password) {
        Toast.makeText(this, "帐号：" + username + ",  密码 :" + password,
                Toast.LENGTH_SHORT).show();
    }
}
