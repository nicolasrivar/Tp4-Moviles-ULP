package com.example.tp4.ui.lista_farmacias;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tp4.databinding.ItemFarmaciaBinding;
import com.example.tp4.model.Farmacia;
import java.util.List;

public class FarmaciaAdapter extends RecyclerView.Adapter<FarmaciaAdapter.FarmaciaViewHolder> {
    private List<Farmacia> farmacias;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Farmacia farmacia);
    }

    public FarmaciaAdapter(List<Farmacia> farmacias, OnItemClickListener listener) {
        this.farmacias = farmacias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FarmaciaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFarmaciaBinding binding = ItemFarmaciaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FarmaciaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmaciaViewHolder holder, int position) {
        Farmacia farmacia = farmacias.get(position);
        holder.bind(farmacia, listener);
    }

    @Override
    public int getItemCount() {
        return farmacias.size();
    }

    public static class FarmaciaViewHolder extends RecyclerView.ViewHolder {
        private ItemFarmaciaBinding binding;

        public FarmaciaViewHolder(@NonNull ItemFarmaciaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Farmacia farmacia, OnItemClickListener listener) {
            binding.farmaciaTextView.setText(farmacia.getNombre());
            binding.farmaciaHorarioTextView.setText(farmacia.getHorario());
            binding.farmaciaImageView.setImageResource(farmacia.getImagenResourceId());
            binding.getRoot().setOnClickListener(v -> listener.onItemClick(farmacia));
        }
    }
}