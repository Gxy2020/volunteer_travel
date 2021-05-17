package yqc.volunteer_travel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "attractions")
public class Attractions implements Serializable {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "image")
    private String image;
    @Column(name = "attractions_name")
    private String name;
    @Column(name = "attractions_address")
    private String address;
    @Column(name = "attractions_describe")
    private String describe;
    @Column(name = "attractions_status")
    private Integer status;
    @Column(name = "create_date")
    private Date createDate;


    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getDescribe() { return describe; }

    public void setDescribe(String describe) { this.describe = describe; }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    public Date getCreateDate() { return createDate; }

    public void setCreateDate(Date createDate) { this.createDate = createDate; }
}
