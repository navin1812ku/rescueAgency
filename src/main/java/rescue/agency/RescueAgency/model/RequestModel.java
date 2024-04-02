package rescue.agency.RescueAgency.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String requestContact;
    @Column(nullable = false)
    private String replyContent;
    @Column(nullable = false)
    private String replyContact;
}
