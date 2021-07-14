package br.com.abrito.ponto.service;

import br.com.abrito.ponto.model.CategoriaUsuario;
import br.com.abrito.ponto.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaUsuarioService {


    CategoriaUsuarioRepository repository;

    @Autowired
    public CategoriaUsuarioService(CategoriaUsuarioRepository repository) {
        this.repository = repository;
    }

    public CategoriaUsuario save(CategoriaUsuario entity){
       return repository.save(entity);
    }

    public List<CategoriaUsuario> findAll() {
       return repository.findAll();
    }

    public Optional<CategoriaUsuario> getById(Long id) {
        return repository.findById(id);
    }

    public CategoriaUsuario update(CategoriaUsuario entity){
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
