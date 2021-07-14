package br.com.abrito.ponto.service;

import br.com.abrito.ponto.model.JornadaTrabalho;
import br.com.abrito.ponto.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaService {


    JornadaRepository repository;

    @Autowired
    public JornadaService(JornadaRepository repository) {
        this.repository = repository;
    }

    public JornadaTrabalho save(JornadaTrabalho entity){
       return repository.save(entity);
    }

    public List<JornadaTrabalho> findAll() {
       return repository.findAll();
    }

    public Optional<JornadaTrabalho> getById(Long id) {
        return repository.findById(id);
    }

    public JornadaTrabalho update(JornadaTrabalho entity){
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
