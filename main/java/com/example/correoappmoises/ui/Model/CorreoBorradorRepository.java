package com.example.correoappmoises.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class CorreoBorradorRepository {
    public ArrayList<CorreoBorrador> CorreosBorradores;

    public CorreoBorradorRepository() {
        this.CorreosBorradores = new ArrayList<>();
    }

    public List<CorreoBorrador> getBorradores(){
        return CorreosBorradores;
    }

    public void insert (CorreoBorrador borrador){
        CorreosBorradores.add(borrador);
    }

    public void update (CorreoBorrador borrador){

    }

    public void delete (int uid){
        for(CorreoBorrador x: getBorradores()){
            if(x.getUid()==uid){
                CorreosBorradores.remove(x);
            }
        }
    }
}
