package com.android.youth.component;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.youth.R;
import com.android.youth.utils.DatabaseHelper;

import java.util.ArrayList;

/**
 * Created by septian.bagus on 21/05/2018.
 */

public class CustomAdapter extends BaseAdapter {
    private Context mContext;

    DatabaseHelper controldb;
    SQLiteDatabase db;

    private ArrayList<String> Name = new ArrayList<String>();

    private ArrayList<String> Email = new ArrayList<String>();

    public CustomAdapter(Context  context,ArrayList<String> Name, ArrayList<String> Email) {
        this.mContext = context;
        this.Name = Name;
        this.Email = Email;
    }

    @Override
    public int getCount() {
        return Name.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final    viewHolder holder;
        controldb = new DatabaseHelper(mContext);
        LayoutInflater layoutInflater;

        if (convertView == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_fragment, null);
            holder = new viewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.tvMenuTitle);
            holder.mail = (TextView) convertView.findViewById(R.id.tvMenuDesc);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }
        holder.name.setText(Name.get(position));
        holder.mail.setText(Email.get(position));
        return convertView;
    }

    public class viewHolder {
        TextView name;
        TextView mail;
    }
}