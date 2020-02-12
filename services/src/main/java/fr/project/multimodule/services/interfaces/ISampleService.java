package fr.project.multimodule.services.interfaces;

import fr.project.multimodule.data.entities.SampleEntity;

import java.util.List;

public interface ISampleService {
    List<SampleEntity> getAll();
    SampleEntity getById(int id);
}
