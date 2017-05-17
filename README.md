# BlueHelper
An Android library to work with bluetooth more easily

### How to

##### Enable or Disable Bluetooth
Create a instance of `BlueHelper`
``` java
BlueHelper blueHelper = new BlueHelper();

// code
blueHelper.enable();
blueHelper.disable();
```

You can create a state listener too, but it's optional:
``` java
StateListener bluetoothStateListener = new StateListener() {
        @Override
        public void onStateOn() {
            // TODO
        }

        @Override
        public void onStateOff() {
            // TODO
        }
    };

// put your listener at constructor
BlueHelper blueHelper = new BlueHelper(bluetoothStateListener);
```


```
MIT License

Copyright (c) 2017 Stone Pagamentos

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
