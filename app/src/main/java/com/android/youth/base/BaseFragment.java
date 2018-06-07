package com.android.youth.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by septian.bagus on 14/05/2018.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    protected IBaseActivity iBaseActivity;

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        iBaseActivity = (IBaseActivity) (activity);
//    }

    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iBaseActivity = (IBaseActivity) (context);
    }

    /*
     * Deprecated on API 23
     * Use onAttachToContext instead
     */
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < 23) {
            iBaseActivity = (IBaseActivity) (activity);
        }
    }


    public BaseFragment() {
        // Required empty public constructor
    }
}
