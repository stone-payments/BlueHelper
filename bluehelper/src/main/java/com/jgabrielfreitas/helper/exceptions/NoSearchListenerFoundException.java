package com.jgabrielfreitas.helper.exceptions;

/**
 * Created by JGabrielFreitas on 18/05/17.
 */

public class NoSearchListenerFoundException extends Exception {

  @Override public String getMessage() {
    return "There's no SearchListener found";
  }
}
