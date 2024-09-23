package com.example.tp4.ui.lista_farmacias;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.tp4.R;
import com.example.tp4.model.Farmacia;
import java.util.ArrayList;
import java.util.List;

public class ListaFarmaciasViewModel extends ViewModel {
    private final MutableLiveData<List<Farmacia>> farmaciasLiveData;
    private final MutableLiveData<Farmacia> farmaciaSeleccionada;

    public ListaFarmaciasViewModel() {
        farmaciasLiveData = new MutableLiveData<>();
        farmaciaSeleccionada = new MutableLiveData<>();
        cargarFarmacias();
    }

    private void cargarFarmacias() {
        List<Farmacia> farmacias = new ArrayList<>();
        farmacias.add(new Farmacia("ULP", "Lunes a Viernes: 9am - 5pm", R.drawable.farmacia1));
        farmacias.add(new Farmacia("San Luis", "Lunes a Domingo: 8am - 10pm", R.drawable.farmacia2));
        farmaciasLiveData.setValue(farmacias);
    }

    public LiveData<List<Farmacia>> getFarmacias() {
        return farmaciasLiveData;
    }

    public void seleccionarFarmacia(Farmacia farmacia) {
        farmaciaSeleccionada.setValue(farmacia);
    }

    public LiveData<Farmacia> getFarmaciaSeleccionada() {
        return farmaciaSeleccionada;
    }
}