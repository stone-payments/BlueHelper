package com.jgabrielfreitas.helper;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;

import com.jgabrielfreitas.helper.actions.DiscoverableAction;
import com.jgabrielfreitas.helper.exceptions.BluetoothNotEnabledException;
import com.jgabrielfreitas.helper.listeners.BluetoothListener.StateListener;

import static android.bluetooth.BluetoothAdapter.getDefaultAdapter;
import static com.jgabrielfreitas.helper.BluetoothManager.getAdapter;

/**
 * Created by JGabrielFreitas on 16/05/17.
 */

public class BlueHelper {

    final boolean ON  = true;
    final boolean OFF = false;
    private StateListener bluetoothStateListener;

    public BlueHelper() {}

    public BlueHelper(StateListener bluetoothStateListener) {
        this();
        this.bluetoothStateListener = bluetoothStateListener;
    }

    /**
     * turn bluetooth on if it's already off
     */
    public void enable() {
        if (BluetoothManager.isEnabled() == OFF)
            getAdapter().enable();

        if (bluetoothStateListener != null)
            bluetoothStateListener.onStateOn();
    }

    /**
     * turn bluetooth off if it's already on
     */
    public void disable() {
        if (BluetoothManager.isEnabled() == ON)
            getAdapter().disable();

        if (bluetoothStateListener != null)
            bluetoothStateListener.onStateOff();
    }

    public void makeDiscoverable(Activity activity) throws BluetoothNotEnabledException {
        int TWO_SECONDS = 2;
        new DiscoverableAction(activity).makeDiscoverable(TWO_SECONDS);
    }

}
