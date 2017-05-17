package com.jgabrielfreitas.bluetoothhelperdemo;

import android.widget.Toast;

import com.jgabrielfreitas.core.activity.BaseActivity;
import com.jgabrielfreitas.helper.BlueHelper;
import com.jgabrielfreitas.helper.listeners.BluetoothListener;
import com.jgabrielfreitas.helper.listeners.BluetoothListener.StateListener;
import com.jgabrielfreitas.layoutid.annotations.InjectLayout;

import butterknife.OnClick;

@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    // bluetooth properties
    private StateListener bluetoothStateListener = new StateListener() {
        @Override
        public void onStateOn() {
            Toast.makeText(MainActivity.this, "bluetooth enabled", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStateOff() {
            Toast.makeText(MainActivity.this, "bluetooth disabled", Toast.LENGTH_SHORT).show();
        }
    };
    private BlueHelper blueHelper = new BlueHelper(bluetoothStateListener);


    @OnClick(R.id.enableBluetoothButton)
    public void enableBluetooth() {
        blueHelper.enable();
    }

    @OnClick(R.id.disableBluetoothButton)
    public void disableBluetooth() {
        blueHelper.disable();
    }

}
