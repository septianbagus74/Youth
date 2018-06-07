package com.android.youth.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.android.youth.R;

/**
 * Created by septian.bagus on 14/05/2018.
 */

public class DialogUtil {

    public static void showAlertDialog(Context context, String content) {
        showPositiveDialog(context, context.getString(R.string.warning), content, null);
    }

    public static void showPositiveDialog(Context context, String title, String content, Dialog.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AppCompatAlertDialogStyle);
        builder.setTitle(title);
        builder.setMessage(content);
        builder.setPositiveButton(context.getString(R.string.ok), onClickListener);
        builder.show();
    }

    public static void showConfirmationDialog(Context context, String content, DialogInterface.OnClickListener positiveClick) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AppCompatAlertDialogStyle);
        builder.setTitle(context.getString(R.string.confirmation));
        builder.setMessage(content);
        builder.setPositiveButton(context.getString(R.string.ok), positiveClick);
        builder.setNegativeButton(context.getString(R.string.cancel), null);
        builder.show();
    }
}
