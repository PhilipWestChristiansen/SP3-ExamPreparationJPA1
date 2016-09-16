package entity;

import javax.persistence.*;

@Entity
public class ProjectUsers {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String email;
    private String created;
    
}
