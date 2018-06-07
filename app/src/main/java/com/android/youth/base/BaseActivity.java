package com.android.youth.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by septian.bagus on 14/05/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void goToScreen(Context context, Class<?> destActivity) {
        Intent intent = new Intent(context, destActivity);
        startActivity(intent);
    }
}
