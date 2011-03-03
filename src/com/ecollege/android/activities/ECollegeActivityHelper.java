package com.ecollege.android.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.ecollege.android.ECollegeApplication;
import com.ecollege.android.LoginActivity;
import com.ecollege.android.R;


public class ECollegeActivityHelper {

    public static ProgressDialog createProgressDialog(final ECollegeActivity eactivity) {
    	final Activity activity = (Activity)eactivity;
        ProgressDialog progressDialog = new ProgressDialog(activity);

        int progressDialogTitleId = eactivity.getApp().getNextProgressDialogTitleId();
        int progressDialogMsgId = eactivity.getApp().getNextProgressDialogMsgId();
        
        if (progressDialogTitleId <= 0) {
            progressDialogTitleId = R.string.progress_dialog_default_title;
        }
        if (progressDialogMsgId <= 0) {
            progressDialogMsgId = R.string.progress_dialog_default_message;
        }
        progressDialog.setTitle(progressDialogTitleId);
        progressDialog.setMessage(activity.getString(progressDialogMsgId));
        progressDialog.setIndeterminate(true);
        progressDialog.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                activity.onKeyDown(keyCode, event);
                return false;
            }
        });
        // progressDialog.setInverseBackgroundForced(true);
        return progressDialog;
    }
    
	public static boolean onCreateOptionsMenu(Activity activity, Menu menu) {
		if (activity instanceof LoginActivity) {
			//do nothing for login activity
			return false;
		} else {
			activity.getMenuInflater().inflate(R.menu.default_menu, menu);
			return true;
		}
	}
	
	public static boolean onOptionsItemSelected(Activity activity, MenuItem item) {
		if (item.getItemId() == R.id.settings_menu_item) {
			//TODO
			//activity.startActivity(new Intent(activity, MainActivity.class));
			//return true;
		}
		if (item.getItemId() == R.id.logout_menu_item) {
			ECollegeApplication app = (ECollegeApplication)activity.getApplication();
			app.logout();
			return true;
		}		
		return false;
	}
	
}