package com.ort.atqr.Service;

import com.ort.atqr.Exception.InvalidInputException;
import com.ort.atqr.Model.Asignature;
import com.ort.atqr.Repository.AsignatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AsignatureServiceImpl {

    private AsignatureRepository asignatureRepository;

    @Autowired
    public AsignatureServiceImpl(AsignatureRepository asignatureRepository) {this.asignatureRepository = asignatureRepository;}

    public Asignature createNewAsignature(Asignature asignature){
        try{
            asignature.validate();
            return asignatureRepository.save(asignature);
        } catch(InvalidInputException e){
            e.printStackTrace();
            return null;
        }
    }

    public void deleteAsignature(String id){asignatureRepository.deleteById(id);}
}
