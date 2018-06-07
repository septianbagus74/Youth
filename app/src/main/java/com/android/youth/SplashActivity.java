package com.android.youth;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.android.youth.intro.WelcomeActivity;
import com.android.youth.utils.DialogUtil;

public class SplashActivity extends Activity {

    String[] PERMISSIONS = {Manifest.permission.INTERNET};
    int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    String TAG = "PERMISSION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        askForPermission();
    }

    private void askForPermission() {
        ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST_ID_MULTIPLE_PERMISSIONS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Log.d(TAG, "Permission callback called-------");
        if (requestCode == REQUEST_ID_MULTIPLE_PERMISSIONS) {
            // Fill with actual results from user
            if (grantResults.length > 0) {
                // Check for all permissions
                if (allPermissionGranted()) {
                    //Application Running Normally
                    runApplication();
                } else {
                    Log.d(TAG, "Some permissions are not granted ask again ");
                    //permission is denied (this is the first time, when "never ask again" is not checked) so ask again explaining the usage of permission
//                        // shouldShowRequestPermissionRationale will return true
                    //show the dialog or snackbar saying its necessary and try again otherwise proceed with setup.
                    if (isNeverAskChecked()) {
                        Log.d(TAG, "Not Checked");
                        askForPermission();
                    }

                    //permission is denied (and never ask again is  checked)
                    //shouldShowRequestPermissionRationale will return false
                    else {
                        DialogUtil.showPositiveDialog(this, "Peringatan", "Silakan aktifkan perizinan aplikasi ini melalui manajer aplikasi di menu pengaturan", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        //                            //proceed with logic by disabling the related features or quit the app.
                    }
                }
            }
        }

    }

    private void runApplication() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }

    public boolean allPermissionGranted() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (int i = 0; i < PERMISSIONS.length; i++) {
                if (ActivityCompat.checkSelfPermission(this, PERMISSIONS[i]) == PackageManager.PERMISSION_DENIED) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isNeverAskChecked() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (int i = 0; i < PERMISSIONS.length; i++) {
                if (shouldShowRequestPermissionRationale(PERMISSIONS[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
