package com.xw.dialogfragmentdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2017/6/29 0029.
 *
 * 传统的Dialog旋转屏幕时就消失了，且后台log会报异常~~~使用DialogFragment则不受影响。
 */

public class LoginDialogFragment extends DialogFragment {

    private EditText mUsername;
    private EditText mPassword;


    //
    public interface LoginInputListener {
        void onLoginInputComplete(String username, String password);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_login_dialog, null);
        mUsername = (EditText) view.findViewById(R.id.id_txt_username);
        mPassword = (EditText) view.findViewById(R.id.id_txt_password);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Sign in",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                     //点击登录的时候，把activity强转为我们自定义的接口：LoginInputListener，然后将用户输入的数据返回
                                LoginInputListener listener = (LoginInputListener) getActivity();
                                listener.onLoginInputComplete(mUsername
                                        .getText().toString(), mPassword
                                        .getText().toString());

                            }
                        })
                .setNegativeButton("Cancel", null);
        return builder.create();
    }


}
