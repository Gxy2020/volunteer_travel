package yqc.volunteer_travel.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_attractions")
public class UserAttractions implements Serializable {
    @Id
    @Column(name = "id")
    private String id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "attractions_id")
    private Attractions attractions;

    @Column(name = "user_attractions_describe")
    private String describe;

    @Column(name = "create_date")
    private Date createDate;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Attractions getAttractions() { return attractions; }

    public void setAttractions(Attractions attractions) { this.attractions = attractions; }

    public String getDescribe() { return describe; }

    public void setDescribe(String describe) { this.describe = describe; }

    public Date getCreateDate() { return createDate; }

    public void setCreateDate(Date createDate) { this.createDate = createDate;}
}
