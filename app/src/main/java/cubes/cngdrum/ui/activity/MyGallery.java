package cubes.cngdrum.ui.activity;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Gallery;

/**
 * Created by User on 10.7.2016.
 */
public class MyGallery extends Gallery {
    private Handler handler;

    public MyGallery(Context ctx, AttributeSet attrSet) {
        super(ctx, attrSet);
        handler = new Handler();
        postDelayedScrollNext();
    }

    private void postDelayedScrollNext() {
        handler.postDelayed(new Runnable() {
            public void run() {
                // check to see if we are at the image is at the last index, if so set the
                // selection back to 1st image.
                if (getSelectedItemPosition() == getCount() - 1) {
                    setSelection(0);
                    postDelayedScrollNext();
                    return;
                }
                postDelayedScrollNext();

                onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
            }
        }, 5000);

    }

    private boolean isScrollingLeft(MotionEvent e1, MotionEvent e2) {
        return e2.getX() > e1.getX();
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        int kEvent;
        if (isScrollingLeft(e1, e2)) {
            kEvent = KeyEvent.KEYCODE_DPAD_LEFT;
        } else {
            kEvent = KeyEvent.KEYCODE_DPAD_RIGHT;
        }
        onKeyDown(kEvent, null);
        return true;
    }
}
