package com.example.kevinpc.elistvoice.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;

import java.sql.SQLException;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by kevinPC on 16/08/2016.
 */
public abstract class BaseFragment extends Fragment{
    protected OnFragmentInteractionListener mFragmentListener;

    private Unbinder unbinder;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mFragmentListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            mFragmentListener = null;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFragmentListener = null;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        //ButterKnife.un(this);
        unbinder.unbind();
    }

    protected void notifyFragmentListener(View view) throws SQLException {
        if(mFragmentListener != null) mFragmentListener.onFragmentInteraction(view);
    }
}
