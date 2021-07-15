package br.com.abrito.ponto.service;

import br.com.abrito.ponto.model.TipoData;
import br.com.abrito.ponto.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {


    TipoDataRepository repository;

    @Autowired
    public TipoDataService(TipoDataRepository repository) {
        this.repository = repository;
    }

    public TipoData save(TipoData entity){
       return repository.save(entity);
    }

    public List<TipoData> findAll() {
       return repository.findAll();
    }

    public Optional<TipoData> getById(Long id) {
        return repository.findById(id);
    }

    public TipoData update(TipoData entity){
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
