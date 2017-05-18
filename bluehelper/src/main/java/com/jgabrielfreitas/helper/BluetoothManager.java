package com.jgabrielfreitas.helper;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import java.util.Set;

import static android.bluetooth.BluetoothAdapter.getDefaultAdapter;

/**
 * Created by JGabrielFreitas on 17/05/17.
 */

public class BluetoothManager {

  static final boolean ON  = true;

  public static boolean isEnabled() {
    return currentState() == ON;
  }

  private static boolean currentState() {
    return getAdapter().isEnabled();
  }

  public static BluetoothAdapter getAdapter() {
    return getDefaultAdapter();
  }

  /**
   * Get all paired devices
   * */
  public static Set<BluetoothDevice> getPairedDevices() {
    return getAdapter().getBondedDevices();
  }

  public static void startSearch() {
    if (getAdapter().isDiscovering()) {
      getAdapter().cancelDiscovery();
      getAdapter().startDiscovery();
    } else getAdapter().startDiscovery();
  }

}
