package com.example.tp4.ui.lista_farmacias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.tp4.R;
import com.example.tp4.databinding.FragmentListaFarmaciasBinding;

public class ListaFarmaciasFragment extends Fragment {
    private FragmentListaFarmaciasBinding binding;
    private ListaFarmaciasViewModel listaFarmaciasViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentListaFarmaciasBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listaFarmaciasViewModel = new ViewModelProvider(requireActivity()).get(ListaFarmaciasViewModel.class);

        binding.recyclerViewFarmacias.setLayoutManager(new LinearLayoutManager(requireContext()));

        listaFarmaciasViewModel.getFarmacias().observe(getViewLifecycleOwner(), farmacias -> {
            FarmaciaAdapter adapter = new FarmaciaAdapter(farmacias, farmacia -> {
                listaFarmaciasViewModel.seleccionarFarmacia(farmacia);
                Navigation.findNavController(view).navigate(R.id.farmaciaDetallesFragment);
            });
            binding.recyclerViewFarmacias.setAdapter(adapter);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}