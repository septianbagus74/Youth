package com.android.youth.fragment;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.youth.R;
import com.android.youth.adapter.UsersRecyclerAdapter;
import com.android.youth.base.BaseFragment;
import com.android.youth.model.User;
import com.android.youth.utils.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeFragment extends BaseFragment {

    private List<User> listUsers;
    private DatabaseHelper databaseHelper;
    private UsersRecyclerAdapter usersRecyclerAdapter;

    @BindView(R.id.imgTalk1)
    ImageView imgTalk1;

    @BindView(R.id.recyclerViewUsers)
    RecyclerView recyclerViewUsers;

    @BindView(R.id.imgTalk2)
    ImageView imgTalk2;

    @BindView(R.id.talk1)
    TextView talk1;

    @BindView(R.id.talk2)
    TextView talk2;

    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        ButterKnife.bind(this, view);

        talk1.setOnClickListener(this);
        //Set Label Version
        PackageInfo pInfo = null;
        try {
            pInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        initObjects();
        return view;
    }

    private void initObjects() {
        listUsers = new ArrayList<>();
        usersRecyclerAdapter = new UsersRecyclerAdapter(listUsers);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewUsers.setLayoutManager(mLayoutManager);
        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsers.setHasFixedSize(true);
        recyclerViewUsers.setAdapter(usersRecyclerAdapter);
        databaseHelper = new DatabaseHelper(getActivity());

//        String emailFromc

        getDataFromSQLite();
    }

    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(databaseHelper.getAllUser());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                usersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.talk1) {
            talk1.setVisibility(View.GONE);
            imgTalk1.setVisibility(View.GONE);
            talk2.setVisibility(View.VISIBLE);
            imgTalk2.setVisibility(View.VISIBLE);
        }
    }
}