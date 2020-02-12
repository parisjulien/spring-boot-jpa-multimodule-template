package fr.project.multimodule.data.repositories;

import fr.project.multimodule.data.entities.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISampleRepository extends JpaRepository<SampleEntity, Integer> {
}
