package fr.project.multimodule.restapi.controllers;

import fr.project.multimodule.data.entities.SampleEntity;
import fr.project.multimodule.services.SampleService;
import fr.project.multimodule.services.interfaces.ISampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/samples")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST})
public class SampleController {

    @Autowired
    private ISampleService sampleService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleService.class);

    public SampleController() {}

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getSamples() {
        List<SampleEntity> entities;

        try {
            entities = this.sampleService.getAll();
            LOGGER.info(entities.toString());

            return ResponseEntity.ok(new HashMap<String, Object>() {
                { put("entities", entities); }
            });
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return new ResponseEntity<>(new HashMap<String, Object>() {
                { put("Message", ex.getMessage()); }
            }, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
