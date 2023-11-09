
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://southtelecom.vn/images/logo-white.png)

Group barcode detect and decode Android
## Getting Started

The SDK used for supporting barcode detection in groups and decoding them into readable codes is an essential component of the project. This SDK provides the necessary functionalities and tools to effectively detect and decode barcodes in a group setting.

### Require
```compileSdk 34``` in `app/build.gradle`

### Installation

1. In `android/build.gradle`
Add this 
```Java
buildscript {
    ext {
        agp_version = '8.1.2'
        java_version = JavaVersion.VERSION_1_8
        kotlin_version= '1.8.0'
    }
}
plugins {
    ...
    id 'androidx.navigation.safeargs' version '2.5.0' apply false
    id "de.undercouch.download" version "5.5.0"
}
task clean(type: Delete) {
    delete rootProject.buildDir
}
```
2. In `Android Studio` do : `File -> Project Structure -> Dependencies -> import` then select `sdkbarcode` module.

3. In `Preject Structure` window `Dependencies` tab select `app` press `+` -> `Module Dependency` select `sdkbarcode` -> `OK`.



## Usage

This is an example demonstrating how to use the SDK to perform barcode scanning and retrieve results accurately.

1. `MainActivity` create a button to open `scan` feature 
2. Create `onActivityResult` fun to get result from `sdkbarcode`
3. The example
```Java
package com.example.bacode

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.navigation.ui.AppBarConfiguration
import org.tensorflow.lite.examples.objectdetection.SDKBarcodeStelResult

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private var R_CODE_SDK_BARCODE_STEL = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, org.tensorflow.lite.examples.objectdetection.MainActivity::class.java)
            startActivityForResult(intent, R_CODE_SDK_BARCODE_STEL)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("CameraFragment","aa")
        if(requestCode == R_CODE_SDK_BARCODE_STEL) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d("CameraFragment", SDKBarcodeStelResult.resultsJSON.toString())

                val status = data?.getStringExtra("status");


            } else if(resultCode == Activity.RESULT_CANCELED) {
                val status = data?.getStringExtra("status");
                val error = data?.getStringExtra("error");
            }
        }
    }
}
```
Json result
```Json
[
  {
    "bitmap": "...",
    "width": ...,
    "height": ...,
    "haveBarCode": ...,
    "barcodes": [
      {
        "bitmap": "...",
        "width": ...,
        "height": ...,
        "bytes": ...,
        "status": ...,
        "bounds": "...",
        "corners": "...",
        "rawValue": "...",
        "valueType": "..."
      },
      {
        "bitmap": "...",
        "width": ...,
        "height": ...,
        "bytes": ...,
        "status": ...,
        "bounds": "...",
        "corners": "...",
        "rawValue": "...",
        "valueType": "..."
      }
    ]
  },
  {
    "bitmap": "...",
    "width": ...,
    "height": ...,
    "haveBarCode": ...,
    "barcodes": [
      {
        "bitmap": "...",
        "width": ...,
        "height": ...,
        "bytes": ...,
        "status": ...,
        "bounds": "...",
        "corners": "...",
        "rawValue": "...",
        "valueType": "..."
      },
      {
        "bitmap": "...",
        "width": ...,
        "height": ...,
        "bytes": ...,
        "status": ...,
        "bounds": "...",
        "corners": "...",
        "rawValue": "...",
        "valueType": "..."
      }
    ]
  },
  
]
```







## Authors

- Southtelecom

