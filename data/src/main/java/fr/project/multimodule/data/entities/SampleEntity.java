package fr.project.multimodule.data.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class SampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String value;

    public SampleEntity() {}
    public SampleEntity(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public void setId (Integer id) { this.id = id; }
    public void setValue (String value) { this.value = value; }

    public Integer getId() { return this.id; }
    public String getValue() { return this.value; }
}
