package br.com.abrito.ponto.service;

import br.com.abrito.ponto.model.Ocorrencia;
import br.com.abrito.ponto.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    OcorrenciaRepository repository;

    @Autowired
    public OcorrenciaService(OcorrenciaRepository repository) {
        this.repository = repository;
    }

    public Ocorrencia save(Ocorrencia entity){
       return repository.save(entity);
    }

    public List<Ocorrencia> findAll() {
       return repository.findAll();
    }

    public Optional<Ocorrencia> getById(Long id) {
        return repository.findById(id);
    }

    public Ocorrencia update(Ocorrencia entity){
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
