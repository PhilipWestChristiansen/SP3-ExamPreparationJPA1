package entity;

import javax.persistence.*;

@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String hoursAssigned;
    private String hoursUsed;
    
}
