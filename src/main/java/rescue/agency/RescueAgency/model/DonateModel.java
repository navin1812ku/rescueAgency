package rescue.agency.RescueAgency.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "donate")
@Data
public class DonateModel {
    @Id
    private String requestId;
    @Column(nullable = false)
    private String requestType;
    @Column(nullable = false)
    private String specification;
    @Column(nullable = false)
    private String quantity;
    @Column(nullable = false)
    private String requestedBy;
    @Column(nullable = false)
    private String requesterContact;
    @Column(nullable = false)
    private String requestEndDate;
}
