package com.ort.atqr.Service;

import com.ort.atqr.Exception.InvalidInputException;
import com.ort.atqr.Model.Asignature;
import com.ort.atqr.Repository.AsignatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AsignatureServiceImpl {

    private AsignatureRepository asignatureRepository;

    @Autowired
    public AsignatureServiceImpl(AsignatureRepository asignatureRepository) {this.asignatureRepository = asignatureRepository;}

    public Asignature createNewAsignature(Asignature asignature){
        try{
            asignature.validate();
            Asignature asignature1 = asignatureRepository.findAsignatureByCode(asignature.getCode());
            if(asignature1 != null)
                return asignatureRepository.save(asignature);
            throw new IllegalArgumentException("Ya existe una asignatura con ese codigo");
        } catch(InvalidInputException e){
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<Asignature> getAll(){
        return Optional.ofNullable((List<Asignature>) asignatureRepository.findAll()).orElse(new ArrayList<>());
    }

    public void deleteAsignature(String id){asignatureRepository.deleteById(id);}
}
