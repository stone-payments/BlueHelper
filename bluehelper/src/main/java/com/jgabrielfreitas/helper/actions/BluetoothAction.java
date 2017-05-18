package com.jgabrielfreitas.helper.actions;

import android.app.Activity;

/**
 * Created by JGabrielFreitas on 17/05/17.
 */

abstract class BluetoothAction {

  Activity activity;

  public BluetoothAction(Activity activity) {
    this.activity = activity;
  }
}
