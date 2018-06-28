package com.android.youth.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.youth.R;

/**
 * Created by septian.bagus on 08/06/2018.
 */

public class CustomListHafalan extends RelativeLayout {

    LayoutInflater mInflater;

    public CustomListHafalan(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    public CustomListHafalan(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init(context, attrs);
    }

    public CustomListHafalan(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mInflater.inflate(R.layout.custom_list_hafalan, this, true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.CustomListHafalan);
        int count = typedArray.getIndexCount();

        String title = typedArray
                .getString(R.styleable.CustomListHafalan_title_hafalan);
        String desc = typedArray
                .getString(R.styleable.CustomListHafalan_subtitle_hafalan);

        TextView tv_title = (TextView) findViewById(R.id.tvMenuTitle);
        tv_title.setText(title);

        TextView tv_desc = (TextView) findViewById(R.id.tvMenuDesc);
        tv_desc.setText(desc);

        typedArray.recycle();
    }
}
