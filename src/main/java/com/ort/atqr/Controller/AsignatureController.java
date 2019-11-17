package com.ort.atqr.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ort.atqr.Model.Asignature;
import com.ort.atqr.Service.AsignatureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<>(newAsignature, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Asignature>> getAll(){
        return new ResponseEntity<>(asignatureServiceImpl.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Asignature> deleteAsignature(@PathVariable String code){
        asignatureServiceImpl.deleteAsignature(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
