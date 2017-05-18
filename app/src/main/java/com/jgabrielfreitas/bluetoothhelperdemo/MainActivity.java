package com.jgabrielfreitas.bluetoothhelperdemo;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import android.widget.Toast;

import com.jgabrielfreitas.core.activity.BaseActivity;
import com.jgabrielfreitas.helper.BlueHelper;
import com.jgabrielfreitas.helper.exceptions.BluetoothNotEnabledException;
import com.jgabrielfreitas.helper.exceptions.NoSearchListenerFoundException;
import com.jgabrielfreitas.helper.listeners.BluetoothListener;
import com.jgabrielfreitas.helper.listeners.BluetoothListener.SearchListener;
import com.jgabrielfreitas.helper.listeners.BluetoothListener.StateListener;
import com.jgabrielfreitas.layoutid.annotations.InjectLayout;

import butterknife.OnClick;
import java.util.Set;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends BaseActivity {

  final Activity MAIN_ACTIVITY = this;

  // bluetooth properties
  private StateListener bluetoothStateListener = new StateListener() {
    @Override public void onStateOn() {
      makeText(MAIN_ACTIVITY, "bluetooth enabled", LENGTH_SHORT).show();
    }

    @Override public void onStateOff() {
      makeText(MAIN_ACTIVITY, "bluetooth disabled", LENGTH_SHORT).show();
    }
  };
  private SearchListener searchListener = new SearchListener() {
    @Override public void onStartSearch() {
      makeText(MAIN_ACTIVITY, "starting search for bluetooth devices", LENGTH_SHORT).show();
    }

    @Override public void onNewDeviceFound(BluetoothDevice device) {
      makeText(MAIN_ACTIVITY, "new device founded: " + device.getName(), LENGTH_SHORT).show();
    }

    @Override public void onSearchFinish(Set<BluetoothDevice> devices) {
      makeText(MAIN_ACTIVITY, "total of devices founded: " + devices.size(), LENGTH_SHORT).show();
      blueHelper.unregisterSearch();
    }
  };
  private BlueHelper blueHelper = new BlueHelper(bluetoothStateListener);

  @OnClick(R.id.enableBluetoothButton) public void enableBluetooth() {
    blueHelper.enable();
  }

  @OnClick(R.id.disableBluetoothButton) public void disableBluetooth() {
    blueHelper.disable();
  }

  @OnClick(R.id.discoverableButton) public void discoverableBluetooth() {
    try {
      blueHelper.makeDiscoverable(MAIN_ACTIVITY);
    } catch (BluetoothNotEnabledException e) {
      e.printStackTrace();
    }
  }

  @OnClick(R.id.searchDevicesButton) public void searchSearchForDevices() {
    try {
      blueHelper.searchDevices(MAIN_ACTIVITY, searchListener);
    } catch (NoSearchListenerFoundException e) {
      e.printStackTrace();
    }
  }
}
