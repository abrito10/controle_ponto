package br.com.abrito.ponto.service;

import br.com.abrito.ponto.model.Empresa;
import br.com.abrito.ponto.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {


    EmpresaRepository repository;

    @Autowired
    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public Empresa save(Empresa entity){
       return repository.save(entity);
    }

    public List<Empresa> findAll() {
       return repository.findAll();
    }

    public Optional<Empresa> getById(Long id) {
        return repository.findById(id);
    }

    public Empresa update(Empresa entity){
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
