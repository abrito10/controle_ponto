package br.com.abrito.ponto.controller;

import br.com.abrito.ponto.model.Empresa;
import br.com.abrito.ponto.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    EmpresaService service;

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa entity){
        return service.save(entity);
    }

    @GetMapping
    public List<Empresa> getList(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa>  getByID(@PathVariable("id") Long id) throws Exception {
        return  ResponseEntity.ok(service.getById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Empresa update(@RequestBody Empresa entity){
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByID(@PathVariable("id") Long id) throws Exception {
       try {
           service.delete(id);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return (ResponseEntity<Empresa>) ResponseEntity.ok();
    }
}
