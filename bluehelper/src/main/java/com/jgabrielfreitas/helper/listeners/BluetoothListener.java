package com.jgabrielfreitas.helper.listeners;

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

}
