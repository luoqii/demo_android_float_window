
package org.bangbang.song.demofloatwindow;

import org.bangbang.song.android.commonlib.WindowReflectUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class SimpleFloatActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_float);
        
        // step 1 make new Window object.
        WindowManager wm = getWindowManager();
        Window w = WindowReflectUtil.makeNewWindow(this);
        // step 2 set content view
        w.setContentView(R.layout.activity_simple_float);
        // step 3 set windowmanger to window
        w.setWindowManager(wm, null, "float window");
        // step 4 update decor view content.
        View decoreView = w.getDecorView();
        ((TextView)decoreView.findViewById(R.id.text)).setText("simple float window");
        // step 5 adjust layout params
        LayoutParams params = w.getAttributes();
        // step 6 add decorview.
        wm.addView(decoreView, params);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_simple_float, menu);
        return true;
    }

}
