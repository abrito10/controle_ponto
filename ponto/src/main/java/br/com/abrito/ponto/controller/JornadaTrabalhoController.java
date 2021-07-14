package br.com.abrito.ponto.controller;

import br.com.abrito.ponto.model.JornadaTrabalho;
import br.com.abrito.ponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService service;

    @PostMapping
    public JornadaTrabalho create(@RequestBody JornadaTrabalho entity){
        return service.save(entity);
    }

    @GetMapping
    public List<JornadaTrabalho> getList(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho>  getByID(@PathVariable("id") Long id) throws Exception {
        return  ResponseEntity.ok(service.getById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public JornadaTrabalho update(@RequestBody JornadaTrabalho entity){
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByID(@PathVariable("id") Long id) throws Exception {
       try {
           service.delete(id);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
    }
}
