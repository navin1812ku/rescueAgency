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
    private String request_id;
    @Column(nullable = false)
    private String request_type;
    @Column(nullable = false)
    private String specification;
    @Column(nullable = false)
    private String quantity;
    @Column(nullable = false)
    private String requested_by;
    @Column(nullable = false)
    private String requester_contact;
    @Column(nullable = false)
    private String request_end_date;
}
