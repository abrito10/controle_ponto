package br.com.abrito.ponto.controller;

import br.com.abrito.ponto.model.NivelAcesso;
import br.com.abrito.ponto.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivelAcesso")
public class NivelAcessoController {
    @Autowired
    NivelAcessoService service;

    @PostMapping
    public NivelAcesso create(@RequestBody NivelAcesso entity){
        return service.save(entity);
    }

    @GetMapping
    public List<NivelAcesso> getAllList(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NivelAcesso>  getByID(@PathVariable("id") Long id) throws Exception {
        return  ResponseEntity.ok(service.getById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public NivelAcesso update(@RequestBody NivelAcesso entity){
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByID(@PathVariable("id") Long id) throws Exception {
       try {
           service.delete(id);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return (ResponseEntity<NivelAcesso>) ResponseEntity.ok();
    }
}
