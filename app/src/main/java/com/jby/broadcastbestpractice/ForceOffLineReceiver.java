package com.jby.broadcastbestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;

public class ForceOffLineReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(context);
        dialog.setTitle("Warnning");
        dialog.setMessage("您的账号已在别处登录，已强制下线");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll();
                System.out.println(context.getClass().getSimpleName());
                Intent i=new Intent(context,LoginActivity.class);
                context.startActivity(i);
            }
        });
        dialog.show();
    }
}
