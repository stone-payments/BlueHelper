package com.jgabrielfreitas.helper.exceptions;

/**
 * Created by JGabrielFreitas on 17/05/17.
 */

public class BluetoothNotEnabledException extends Exception {

  @Override public String getMessage() {
    return "The bluetooth isn't enabled";
  }
}
