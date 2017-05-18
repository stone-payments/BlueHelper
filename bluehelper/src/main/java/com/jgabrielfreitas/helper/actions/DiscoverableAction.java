package com.jgabrielfreitas.helper.actions;

import android.app.Activity;
import android.content.Intent;
import com.jgabrielfreitas.helper.BluetoothManager;
import com.jgabrielfreitas.helper.exceptions.BluetoothNotEnabledException;

import static android.bluetooth.BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE;
import static android.bluetooth.BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION;

/**
 * Created by JGabrielFreitas on 17/05/17.
 */

public class DiscoverableAction extends BluetoothAction {

  final boolean ON  = true;
  private final int TEN_SECONDS = 10;
  private int TIME_TO_BE_DISCOVERABLE_STAMP = TEN_SECONDS;

  public DiscoverableAction(Activity activity) {
    super(activity);
  }

  public void makeDiscoverable() throws BluetoothNotEnabledException {
    if (BluetoothManager.isEnabled() == ON) {
      Intent discoverableIntent = new Intent(ACTION_REQUEST_DISCOVERABLE);
      discoverableIntent.putExtra(EXTRA_DISCOVERABLE_DURATION, TIME_TO_BE_DISCOVERABLE_STAMP);
      getActivity().startActivity(discoverableIntent);
    } else throw new BluetoothNotEnabledException();
  }

  public void makeDiscoverable(int duration) throws BluetoothNotEnabledException {
    this.TIME_TO_BE_DISCOVERABLE_STAMP = duration;
    makeDiscoverable();
  }

}
