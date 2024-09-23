package com.example.tp4.ui.lista_farmacias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.tp4.databinding.FragmentFarmaciaDetallesBinding;

public class FarmaciaDetallesFragment extends Fragment {
    private FragmentFarmaciaDetallesBinding binding;
    private ListaFarmaciasViewModel listaFarmaciasViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFarmaciaDetallesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listaFarmaciasViewModel = new ViewModelProvider(requireActivity()).get(ListaFarmaciasViewModel.class);

        listaFarmaciasViewModel.getFarmaciaSeleccionada().observe(getViewLifecycleOwner(), farmacia -> {
            if (farmacia != null) {
                binding.farmaciaNombreTextView.setText(farmacia.getNombre());
                binding.farmaciaHorarioTextView.setText(farmacia.getHorario());
                binding.farmaciaImageView.setImageResource(farmacia.getImagenResourceId());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}