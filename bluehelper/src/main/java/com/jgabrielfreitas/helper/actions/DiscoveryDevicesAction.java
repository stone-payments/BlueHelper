package com.jgabrielfreitas.helper.actions;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.util.ArraySet;
import android.util.Log;
import com.jgabrielfreitas.helper.BluetoothManager;
import com.jgabrielfreitas.helper.exceptions.NoSearchListenerFoundException;
import com.jgabrielfreitas.helper.listeners.BluetoothListener.SearchListener;
import java.util.Set;

import static android.bluetooth.BluetoothAdapter.ACTION_DISCOVERY_FINISHED;
import static android.bluetooth.BluetoothAdapter.ACTION_DISCOVERY_STARTED;
import static android.bluetooth.BluetoothDevice.ACTION_FOUND;
import static android.bluetooth.BluetoothDevice.EXTRA_DEVICE;

/**
 * Created by JGabrielFreitas on 17/05/17.
 */

public class DiscoveryDevicesAction extends BluetoothAction {

  SearchListener discoveryListener;
  Set<BluetoothDevice> found = new ArraySet<>();

  private final BroadcastReceiver devicesReceiver = new BroadcastReceiver() {
    public void onReceive(Context context, Intent intent) {

      final String ACTION = intent.getAction();

      // on finish search
      if (ACTION_DISCOVERY_STARTED.equals(ACTION))
        if (discoveryListener != null)
          discoveryListener.onStartSearch();

      if (ACTION_FOUND.equals(ACTION)) {
        // Discovery has found a device
        BluetoothDevice device = intent.getParcelableExtra(EXTRA_DEVICE);
        if (discoveryListener != null) {
          discoveryListener.onNewDeviceFound(device);
          found.add(device);
        }
      }

      // on finish search
      if (ACTION_DISCOVERY_FINISHED.equals(ACTION)) {
        if (discoveryListener != null) discoveryListener.onSearchFinish(found);
        found = new ArraySet<>();
      }

    }
  };

  public DiscoveryDevicesAction(Activity activity) {
    super(activity);
  }

  public DiscoveryDevicesAction setDiscoveryListener(SearchListener discoveryListener) {
    this.discoveryListener = discoveryListener;
    return this;
  }

  public void startSearchForDevices() throws NoSearchListenerFoundException {
    if (discoveryListener != null) {
      IntentFilter filter = new IntentFilter();

      filter.addAction(ACTION_FOUND);
      filter.addAction(ACTION_DISCOVERY_STARTED);
      filter.addAction(ACTION_DISCOVERY_FINISHED);
      filter.addAction(EXTRA_DEVICE);

      getActivity().registerReceiver(devicesReceiver, filter);
      BluetoothManager.startSearch();
    } else throw new NoSearchListenerFoundException();
  }

  public void unregisterReceiver(){
    if (getActivity() != null)
      getActivity().unregisterReceiver(devicesReceiver);
  }
}
