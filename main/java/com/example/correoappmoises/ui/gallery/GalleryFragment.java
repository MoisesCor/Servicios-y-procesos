package com.example.correoappmoises.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.correoappmoises.R;
import com.example.correoappmoises.databinding.FragmentGalleryBinding;
import com.example.correoappmoises.ui.Model.CorreoBorrador;
import com.example.correoappmoises.ui.Model.CorreoBorradorRepository;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    ArrayList<CorreoBorrador> borradores;

    private CorreoBorradorRepository correoBorradorRepository = new CorreoBorradorRepository();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        ListView listaBorradores= binding.listaBorradoresG;
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(requireActivity()).get(GalleryViewModel.class);
        borradores=(ArrayList<CorreoBorrador>)correoBorradorRepository.getBorradores();
        galleryViewModel.getListaBorradores().observe(getViewLifecycleOwner(),s->{
            GalleryAdapter galleryAdapter = new GalleryAdapter(getContext(), R.layout.borrador_item,s);
            listaBorradores.setAdapter(galleryAdapter);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}