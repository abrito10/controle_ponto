package br.com.abrito.ponto.controller;

import br.com.abrito.ponto.model.TipoData;
import br.com.abrito.ponto.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tipoData")
public class TipoDataController {
    @Autowired
    TipoDataService service;

    @PostMapping
    public TipoData create(@RequestBody TipoData entity){
        return service.save(entity);
    }

    @GetMapping
    public List<TipoData> getList(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoData>  getByID(@PathVariable("id") Long id) throws Exception {
        return  ResponseEntity.ok(service.getById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public TipoData update(@RequestBody TipoData entity){
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByID(@PathVariable("id") Long id) throws Exception {
       try {
           service.delete(id);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return (ResponseEntity<TipoData>) ResponseEntity.ok();
    }
}
