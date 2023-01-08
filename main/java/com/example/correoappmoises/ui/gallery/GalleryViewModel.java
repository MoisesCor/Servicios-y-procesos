package com.example.correoappmoises.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.correoappmoises.ui.Model.CorreoBorrador;
import com.example.correoappmoises.ui.Model.CorreoBorradorRepository;
import com.example.correoappmoises.ui.Model.CorreoEnviados;
import com.example.correoappmoises.ui.Model.CorreoEnviadosRepository;

import java.util.List;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<List<CorreoBorrador>> listBorrador;
    private CorreoBorradorRepository correoBorradorRepository;

    public GalleryViewModel() {
       listBorrador= new MutableLiveData<>();
       correoBorradorRepository= new CorreoBorradorRepository();
    }
    public MutableLiveData<List<CorreoBorrador>> getListaBorradores() {
        return listBorrador;
    }

    public void onClickAlta(CorreoBorrador borrador){
        correoBorradorRepository.insert(borrador);
        //esto es que cada vez que se carga a la lista avise al repositorio para que se actualice
        listBorrador.postValue(correoBorradorRepository.getBorradores());
    }
    public void cargaInicial(){ listBorrador.postValue(correoBorradorRepository.getBorradores());}

}