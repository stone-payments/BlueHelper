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
            bluetoothAdapter().enable();

        if (bluetoothStateListener != null)
            bluetoothStateListener.onStateOn();
    }

    /**
     * turn bluetooth off if it's already on
     */
    public void disable() {
        if (currentState() == ON)
            bluetoothAdapter().disable();

        if (bluetoothStateListener != null)
            bluetoothStateListener.onStateOn();
    }

    private boolean currentState() {
        return bluetoothAdapter().isEnabled();
    }

    public BluetoothAdapter bluetoothAdapter() {
        return getDefaultAdapter();
    }

}
