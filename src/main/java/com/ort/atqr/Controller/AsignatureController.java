package com.ort.atqr.Controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ort.atqr.Model.Asignature;
import com.ort.atqr.Service.AsignatureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/asignature")
public class AsignatureController {
    private final AsignatureServiceImpl asignatureServiceImpl;
    private final ObjectMapper objectMapper;

    @Autowired
    public AsignatureController(AsignatureServiceImpl asignatureServiceImpl, ObjectMapper objectMapper) {
        this.asignatureServiceImpl = asignatureServiceImpl;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity<Asignature> createAsignature(@RequestBody Asignature asignature){
        Asignature newAsignature = asignatureServiceImpl.createNewAsignature(asignature);
        return new ResponseEntity<Asignature>(newAsignature, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Asignature> deleteAsignature(@RequestBody Asignature asignature){
        asignatureServiceImpl.deleteAsignature(asignature);
    }

}
