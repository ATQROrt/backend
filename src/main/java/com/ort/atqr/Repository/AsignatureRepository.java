package com.ort.atqr.Repository;

import com.ort.atqr.Model.Asignature;
import org.springframework.data.repository.CrudRepository;

public interface AsignatureRepository extends CrudRepository<Asignature, String>{

    public Asignature findAsignatureByCode(String code);

}
