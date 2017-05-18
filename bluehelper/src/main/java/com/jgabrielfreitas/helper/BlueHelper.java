package com.jgabrielfreitas.helper;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import com.jgabrielfreitas.helper.actions.DiscoverableAction;
import com.jgabrielfreitas.helper.actions.DiscoveryDevicesAction;
import com.jgabrielfreitas.helper.exceptions.BluetoothNotEnabledException;
import com.jgabrielfreitas.helper.exceptions.NoSearchListenerFoundException;
import com.jgabrielfreitas.helper.listeners.BluetoothListener.SearchListener;
import com.jgabrielfreitas.helper.listeners.BluetoothListener.StateListener;
import java.util.Set;

import static com.jgabrielfreitas.helper.BluetoothManager.getAdapter;

/**
 * Created by JGabrielFreitas on 16/05/17.
 */

public class BlueHelper {

    final boolean ON  = true;
    final boolean OFF = false;
    private StateListener bluetoothStateListener;
    private SearchListener searchListener;
    private DiscoveryDevicesAction discoveryDevicesAction;

    public BlueHelper() {}

    public BlueHelper(StateListener bluetoothStateListener) {
        this();
        this.bluetoothStateListener = bluetoothStateListener;
    }

    public BlueHelper(SearchListener searchListener) {
        this();
        this.searchListener = searchListener;
    }

    public void setBluetoothStateListener(StateListener bluetoothStateListener) {
        this.bluetoothStateListener = bluetoothStateListener;
    }

    public void setSearchListener(SearchListener searchListener) {
        this.searchListener = searchListener;
    }

    /**
     * Turn bluetooth on if it's already off
     */
    public void enable() {
        if (BluetoothManager.isEnabled() == OFF)
            getAdapter().enable();

        if (bluetoothStateListener != null)
            bluetoothStateListener.onStateOn();
    }

    /**
     * Turn bluetooth off if it's already on
     */
    public void disable() {
        if (BluetoothManager.isEnabled() == ON)
            getAdapter().disable();

        if (bluetoothStateListener != null)
            bluetoothStateListener.onStateOff();
    }

    /**
     * Make the device visible to pair with others devices
     * */
    public void makeDiscoverable(Activity activity) throws BluetoothNotEnabledException {
        int TWO_SECONDS = 2;
        new DiscoverableAction(activity).makeDiscoverable(TWO_SECONDS);
    }

    private void instanceDiscoveryDevices(Activity activity) {
        if (discoveryDevicesAction == null) {
            this.discoveryDevicesAction = new DiscoveryDevicesAction(activity);
        }
    }

    public void searchDevices(Activity activity) throws NoSearchListenerFoundException {
        this.searchDevices(activity, searchListener);
    }


    public void searchDevices(Activity activity, SearchListener searchListener) throws NoSearchListenerFoundException {
        instanceDiscoveryDevices(activity);
        this.discoveryDevicesAction.setDiscoveryListener(searchListener).startSearchForDevices();
    }

    public void unregisterSearch() {
        this.discoveryDevicesAction.unregisterReceiver();
    }

    public Set<BluetoothDevice> getPairedDevices() {
        return BluetoothManager.getPairedDevices();
    }


}
