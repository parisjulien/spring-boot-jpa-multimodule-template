package fr.project.multimodule.restapi.controllers;

import fr.project.multimodule.data.entities.SampleEntity;
import fr.project.multimodule.services.interfaces.ISampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
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

    public SampleController() {}

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getSamples() {
        List<SampleEntity> entities;

        try {
            entities = this.sampleService.getAll();

            return ResponseEntity.ok(new HashMap<String, Object>() {
                { put("entities", entities); }
            });
        } catch (Exception ex) {
            return new ResponseEntity<>(new HashMap<String, Object>() {
                { put("Message", ex.getMessage()); }
            }, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
