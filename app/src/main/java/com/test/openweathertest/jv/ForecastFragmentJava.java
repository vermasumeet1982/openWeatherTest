package com.test.openweathertest.jv;

import android.content.Context;
import android.support.v4.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

public abstract class ForecastFragmentJava extends Fragment {

    public static final String CITY = "Orpington";

    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    public abstract String getTitle();

}