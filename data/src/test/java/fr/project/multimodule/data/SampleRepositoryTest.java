package fr.project.multimodule.data;

import fr.project.multimodule.data.entities.SampleEntity;
import fr.project.multimodule.data.repositories.ISampleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SampleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ISampleRepository sampleRepository;

    @Test
    public void whenFindAll_thenReturnSamples() {
        // insert data into h2 in memory database
        SampleEntity e1 = new SampleEntity();
        e1.setValue("value 1");
        SampleEntity e2 = new SampleEntity();
        e2.setValue("value 2");

        this.entityManager.persist(e1);
        this.entityManager.persist(e2);
        this.entityManager.flush();

        // When
        List<SampleEntity> expectedSamples = this.sampleRepository.findAll();

        // then
        assertEquals(e1.getValue(), expectedSamples.get(0).getValue());
        assertEquals(e2.getValue(), expectedSamples.get(1).getValue());
    }
}
