package com.jgabrielfreitas.helper.listeners;

import android.bluetooth.BluetoothDevice;
import java.util.Set;

/**
 * Created by JGabrielFreitas on 16/05/17.
 */

public interface BluetoothListener {

    /**
     * Interface to update Views that work with bluetooth
     * or is waiting for a bluetooth state change
     * */
    interface StateListener {

        /**
         * Called when bluetooth turned on
         * */
        void onStateOn();

        /**
         * Called when bluetooth turned off
         * */
        void onStateOff();
    }

    interface SearchListener {

        /**
         * Tell to the original caller that a search started
         * */
        void onStartSearch();

        /**
         * For each device founded,
         * this method will notify the original caller
         * */
        void onNewDeviceFound(BluetoothDevice device);

        /**
         * Return all devices founded in the search
         * */
        void onSearchFinish(Set<BluetoothDevice> devices);
    }

}
