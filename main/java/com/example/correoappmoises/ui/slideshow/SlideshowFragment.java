package com.example.correoappmoises.ui.slideshow;

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
import com.example.correoappmoises.databinding.FragmentSlideshowBinding;
import com.example.correoappmoises.ui.Model.CorreoEnviados;
import com.example.correoappmoises.ui.Model.CorreoEnviadosRepository;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    ArrayList<CorreoEnviados> correos;

    //probar a crear lista inicial
    private CorreoEnviadosRepository correoEnviadosRepository= new CorreoEnviadosRepository();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        ListView listaEnviadosCorreo=binding.listaEnviadosSL;
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(requireActivity()).get(SlideshowViewModel.class);
        correos=(ArrayList<CorreoEnviados>)correoEnviadosRepository.getCorreos();

        slideshowViewModel.getListaEnviados().observe(getViewLifecycleOwner(),s->{
            SlideShowAdapter slideShowAdapter= new SlideShowAdapter(getContext(),
                    R.layout.enviado_item,s);
            listaEnviadosCorreo.setAdapter(slideShowAdapter);
        });


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}