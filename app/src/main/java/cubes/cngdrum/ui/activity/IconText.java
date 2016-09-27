package cubes.cngdrum.ui.activity;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by markodragonjic on 6/24/16.
 */
public class IconText extends TextView {

    private Context mContext;
    private static Typeface mTypeface;

    public IconText(Context context) {
        super(context);
        this.mContext = context;

        setIconFont();
    }

    public IconText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        setIconFont();
    }

    public IconText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;

        setIconFont();
    }

    private void setIconFont(){

        if(mTypeface==null){
            mTypeface = Typeface.createFromAsset(mContext.getAssets(),
                    "fonts/materialIcons_regular.ttf");
        }

        setTypeface(mTypeface);
    }
}
