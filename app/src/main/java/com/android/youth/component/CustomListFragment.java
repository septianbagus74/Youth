package com.android.youth.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.youth.R;

/**
 * Created by septian.bagus on 21/05/2018.
 */

public class CustomListFragment extends RelativeLayout {

    LayoutInflater mInflater;

    public CustomListFragment(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    public CustomListFragment(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init(context, attrs);
    }

    public CustomListFragment(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mInflater.inflate(R.layout.custom_list_fragment, this, true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.CustomListFragment);
        int count = typedArray.getIndexCount();

        Drawable img = typedArray
                .getDrawable(R.styleable.CustomListFragment_icon_menu);
        String title = typedArray
                .getString(R.styleable.CustomListFragment_title_menu);
        String desc = typedArray
                .getString(R.styleable.CustomListFragment_description_menu);

        TextView tv_title = (TextView) findViewById(R.id.tvMenuTitle);
        tv_title.setText(title);

        TextView tv_desc = (TextView) findViewById(R.id.tvMenuDesc);
        tv_desc.setText(desc);

        ImageView img_image = (ImageView) findViewById(R.id.imgMenuIcon);
        img_image.setImageDrawable(img);

        typedArray.recycle();
    }
}
