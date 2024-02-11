package rescue.agency.RescueAgency.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "request")
@Data
public class RequestModel {
    @Id
    private String request_member_id;
    @Column(nullable = false)
    private String request_description;
    @Column(nullable = false)
    private String request_location;
    @Column(nullable = false)
    private String request_type;
    @Column(nullable = false)
    private String request_replies;
    @Column(nullable = false)
    private String request_contact;
}
