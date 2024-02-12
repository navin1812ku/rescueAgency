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
    private String requestMemberId;
    @Column(nullable = false)
    private String requestDescription;
    @Column(nullable = false)
    private String requestLocation;
    @Column(nullable = false)
    private String requestType;
    @Column(nullable = false)
    private String requestReplies;
    @Column(nullable = false)
    private String requestContact;
}
