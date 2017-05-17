package com.jgabrielfreitas.helper;

import android.bluetooth.BluetoothAdapter;

import com.jgabrielfreitas.helper.listeners.BluetoothListener.StateListener;

import static android.bluetooth.BluetoothAdapter.getDefaultAdapter;

/**
 * Created by JGabrielFreitas on 16/05/17.
 */

public class BlueHelper {

    final boolean ON  = true;
    final boolean OFF = false;
    private StateListener bluetoothStateListener;

    public BlueHelper() {
    }

    public BlueHelper(StateListener bluetoothStateListener) {
        this();
        this.bluetoothStateListener = bluetoothStateListener;
    }

    /**
     * turn bluetooth on if it's already off
     */
    public void enable() {
        if (currentState() == OFF)
            getAdapter().enable();

        if (bluetoothStateListener != null)
            bluetoothStateListener.onStateOff();
    }

    /**
     * turn bluetooth off if it's already on
     */
    public void disable() {
        if (currentState() == ON)
            getAdapter().disable();

        if (bluetoothStateListener != null)
            bluetoothStateListener.onStateOn();
    }

    private boolean currentState() {
        return getAdapter().isEnabled();
    }

    public BluetoothAdapter getAdapter() {
        return getDefaultAdapter();
    }

}
