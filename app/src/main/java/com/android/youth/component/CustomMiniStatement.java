package com.android.youth.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.youth.R;

/**
 * Created by septian.bagus on 04/04/2018.
 */

public class CustomMiniStatement extends RelativeLayout {

    LayoutInflater mInflater;

    public CustomMiniStatement(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
    }

    public CustomMiniStatement(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init(context, attrs);
    }

    public CustomMiniStatement(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mInflater.inflate(R.layout.custom_mini_statement, this, true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.CustomMiniStatement);
        int count = typedArray.getIndexCount();

        String titleStatment = typedArray
                .getString(R.styleable.CustomMiniStatement_title_statement);
        String dateStatement = typedArray
                .getString(R.styleable.CustomMiniStatement_date_statement);
        String poinStatement = typedArray
                .getString(R.styleable.CustomMiniStatement_poin_statement);

        TextView title_statement = (TextView) findViewById(R.id.title_statement);
        title_statement.setText(titleStatment);

        TextView date_statement = (TextView) findViewById(R.id.date_statement);
        date_statement.setText(dateStatement);

        TextView poin_statement = (TextView) findViewById(R.id.poin_statement);
        poin_statement.setText(poinStatement);

        typedArray.recycle();
    }
}
