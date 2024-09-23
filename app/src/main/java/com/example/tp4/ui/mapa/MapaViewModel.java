package com.example.tp4.ui.mapa;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaViewModel extends AndroidViewModel {

    private MutableLiveData<MapaActual> mMapaActual;

    public MapaViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<MapaActual> getMMapaActual() {
        if (mMapaActual == null) {
            mMapaActual = new MutableLiveData<>();
        }
        return mMapaActual;
    }

    public void obtenerMapa() {
        MapaActual mapa = new MapaActual();
        mMapaActual.setValue(mapa);
    }

    public class MapaActual implements OnMapReadyCallback {
        LatLng SANLUIS = new LatLng(-33.280576, -66.332482);
        LatLng ULP = new LatLng(-33.150720, -66.306864);

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            googleMap.addMarker(new MarkerOptions().position(SANLUIS).title("San Luis").snippet("Capital"));
            googleMap.addMarker(new MarkerOptions().position(ULP).title("ULP").snippet("Gran Universidad"));

            CameraPosition cameraPosition = new CameraPosition.Builder().target(ULP).zoom(10).build();
            CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
            googleMap.animateCamera(cameraUpdate);
        }
    }
}
