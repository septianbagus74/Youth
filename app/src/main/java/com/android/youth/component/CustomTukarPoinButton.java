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
 * Created by septian.bagus on 16/03/2018.
 */

public class CustomTukarPoinButton extends RelativeLayout {

    LayoutInflater mInflater;

    public CustomTukarPoinButton(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    public CustomTukarPoinButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init(context, attrs);
    }

    public CustomTukarPoinButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mInflater.inflate(R.layout.custom_tukar_poin_button, this, true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.CustomTukarPoinButton);
        int count = typedArray.getIndexCount();

        Drawable imgDesc = typedArray
                .getDrawable(R.styleable.CustomTukarPoinButton_img_desc);
        String titleDesc = typedArray
                .getString(R.styleable.CustomTukarPoinButton_title_desc);
        String changePoinDesc = typedArray
                .getString(R.styleable.CustomTukarPoinButton_change_poin_desc);
        String buyButton = typedArray
                .getString(R.styleable.CustomTukarPoinButton_btn_buy);

        ImageView img = (ImageView) findViewById(R.id.imgDesc);
        img.setImageDrawable(imgDesc);

        TextView title_desc = (TextView) findViewById(R.id.titleDesc);
        title_desc.setText(titleDesc);

        TextView change_poin = (TextView) findViewById(R.id.tvChangePoinDesc);
        change_poin.setText(changePoinDesc);

        TextView buy_button = (TextView) findViewById(R.id.btnBuy);
        buy_button.setText(buyButton);

        typedArray.recycle();
    }
}
