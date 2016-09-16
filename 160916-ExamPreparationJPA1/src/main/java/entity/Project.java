package entity;

import javax.persistence.*;

@Entity
public class Project {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String created;
    private String lastModifed;
}
