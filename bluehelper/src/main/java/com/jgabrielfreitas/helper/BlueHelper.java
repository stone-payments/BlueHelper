package com.jgabrielfreitas.helper;

import android.bluetooth.BluetoothAdapter;

import static android.bluetooth.BluetoothAdapter.getDefaultAdapter;

/**
 * Created by JGabrielFreitas on 16/05/17.
 */

public class BlueHelper {

    final boolean ON  = true;
    final boolean OFF = false;

    /**
     * turn bluetooth on if it's already off
     */
    public void enable() {
        if (currentState() == OFF)
            bluetoothAdapter().enable();
    }

    /**
     * turn bluetooth off if it's already on
     */
    public void disable() {
        if (currentState() == ON)
            bluetoothAdapter().disable();
    }

    private boolean currentState() {
        return bluetoothAdapter().isEnabled();
    }

    public BluetoothAdapter bluetoothAdapter() {
        return getDefaultAdapter();
    }

}
