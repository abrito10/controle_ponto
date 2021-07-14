package br.com.abrito.ponto.controller;

import br.com.abrito.ponto.model.Ocorrencia;
import br.com.abrito.ponto.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    @Autowired
    OcorrenciaService service;

    @PostMapping
    public Ocorrencia create(@RequestBody Ocorrencia entity){
        return service.save(entity);
    }

    @GetMapping
    public List<Ocorrencia> getAllList(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia>  getByID(@PathVariable("id") Long id) throws Exception {
        return  ResponseEntity.ok(service.getById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Ocorrencia update(@RequestBody Ocorrencia entity){
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByID(@PathVariable("id") Long id) throws Exception {
       try {
           service.delete(id);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return (ResponseEntity<Ocorrencia>) ResponseEntity.ok();
    }
}
