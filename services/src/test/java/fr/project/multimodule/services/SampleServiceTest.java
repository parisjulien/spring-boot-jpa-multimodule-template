package fr.project.multimodule.services;

import fr.project.multimodule.data.entities.SampleEntity;
import fr.project.multimodule.data.repositories.ISampleRepository;
import fr.project.multimodule.services.interfaces.ISampleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SampleServiceTest {

    @Mock
    private ISampleRepository sampleRepository;

    @InjectMocks
    private ISampleService sampleService = new SampleService();

    private List<SampleEntity> samples;

    @BeforeEach
    void setMockupOutput() {
        this.samples = new ArrayList<SampleEntity>() {
            { add(new SampleEntity(1, "value 1")); }
            { add(new SampleEntity(2, "value 2")); }
        };

        when(sampleRepository.findAll()).thenReturn(samples);
    }

    @DisplayName("Test if getAll samples return the right values")
    @Test
    void testGetAll() {
        List<SampleEntity> samples = this.sampleService.getAll();

        assertEquals(this.samples.get(0).getValue(), samples.get(0).getValue());
        assertEquals(this.samples.get(1).getValue(), samples.get(1).getValue());
    }
}
