package br.com.abrito.ponto.controller;

import br.com.abrito.ponto.model.CategoriaUsuario;
import br.com.abrito.ponto.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoriaUsuario")
public class CategoriaUsuarioController {
    @Autowired
    CategoriaUsuarioService service;

    @PostMapping
    public CategoriaUsuario create(@RequestBody CategoriaUsuario entity){
        return service.save(entity);
    }

    @GetMapping
    public List<CategoriaUsuario> getAllList(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaUsuario>  getByID(@PathVariable("id") Long id) throws Exception {
        return  ResponseEntity.ok(service.getById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public CategoriaUsuario update(@RequestBody CategoriaUsuario entity){
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByID(@PathVariable("id") Long id) throws Exception {
       try {
           service.delete(id);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return (ResponseEntity<CategoriaUsuario>) ResponseEntity.ok();
    }
}
