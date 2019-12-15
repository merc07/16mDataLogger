package io.github.thymythos.diagnosticdataviewer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.nitri.gauge.Gauge;

public class IdleFragment extends Fragment implements LiveDataFragment {

    public static IdleFragment newInstance() {
        IdleFragment fragment = new IdleFragment();
        return fragment;
    }

    public IdleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_idle, container, false);
    }

    @Override
    public void setRPM(int rpm) {
        Gauge gauge = getView().findViewById(R.id.gaugeRPM);
        gauge.setDeltaTimeInterval(1);
        gauge.setLowerText(String.valueOf(rpm));
        if (rpm > 2000) rpm = 2000;
        gauge.moveToValue(rpm);
    }

    @Override
    public void setTPS(float tps) {
        Gauge gauge = getView().findViewById(R.id.gaugeTPS);
        gauge.setDeltaTimeInterval(1);
        gauge.setLowerText(String.valueOf(tps));
        if (tps < 1) tps = 1;
        if (tps > 3) tps = 3;
        gauge.moveToValue(tps);
    }

    @Override
    public void setAFR1(float afr) {
        if (afr <= 0) return;
        Gauge gauge = getView().findViewById(R.id.gaugeAFR1);
        gauge.setDeltaTimeInterval(1);
        gauge.setLowerText(String.valueOf(afr));
        if (afr < 11) afr = 11;
        if (afr > 15) afr = 15;
        gauge.moveToValue(afr);
    }

    @Override
    public void setAFR2(float afr) {
        if (afr <= 0) return;
        Gauge gauge = getView().findViewById(R.id.gaugeAFR2);
        gauge.setDeltaTimeInterval(1);
        gauge.setLowerText(String.valueOf(afr));
        if (afr < 11) afr = 11;
        if (afr > 15) afr = 15;
        gauge.moveToValue(afr);
    }

    @Override
    public void setCoolantTemp(String temp) {
        Gauge gauge = getView().findViewById(R.id.gaugeRPM);
        gauge.setUpperText(temp);
    }
}
