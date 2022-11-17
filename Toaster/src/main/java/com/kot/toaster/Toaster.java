package com.kot.toaster;

import android.content.Context;
import android.location.Location;
import android.widget.Toast;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesWithFallbackProvider;

public class Toaster {
    public static void Toasting(Context context,String msg){

        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();


    }
    public static void getcurrentlocatin(Context context){
        SmartLocation.with(context)
                .location(new LocationGooglePlayServicesWithFallbackProvider(context))
                .oneFix()
                .start(new OnLocationUpdatedListener() {
                    @Override
                    public void onLocationUpdated(Location location) {
                        Toast.makeText(context,String.valueOf(location.getLatitude())+ String.valueOf(location.getLongitude()),Toast.LENGTH_LONG).show();
                        // onLocationFetchFinished.onFinished(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
                    }
                });
    }
}
