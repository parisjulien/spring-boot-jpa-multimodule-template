package fr.project.multimodule.services;

import fr.project.multimodule.data.entities.SampleEntity;
import fr.project.multimodule.data.repositories.ISampleRepository;
import fr.project.multimodule.services.interfaces.ISampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService implements ISampleService {

    @Autowired
    private ISampleRepository repository;

    @Override
    public List<SampleEntity> getAll() {
        return this.repository.findAll();
    }

    @Override
    public SampleEntity getById(int id) {
        return this.repository.findById(id).get();
    }
}
