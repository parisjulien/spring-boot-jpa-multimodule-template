package fr.project.multimodule.services;

import fr.project.multimodule.data.entities.SampleEntity;
import fr.project.multimodule.data.repositories.ISampleRepository;
import fr.project.multimodule.services.interfaces.ISampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService implements ISampleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleService.class);

    @Autowired
    private ISampleRepository repository;

    @Override
    public List<SampleEntity> getAll() {
        LOGGER.info("test");
        return this.repository.findAll();
    }

    @Override
    public SampleEntity getById(int id) {
        return this.repository.findById(id).get();
    }
}
