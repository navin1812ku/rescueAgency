package rescue.agency.RescueAgency.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "agency")
@Data
public class AgencyModel {
    @Id
    private String agencyEmail;
    @Column(nullable = false)
    private String agencyName;
    @Column(nullable = false)
    private String agencyContact;
    @Column(nullable = false)
    private List<String> agencyExpertise;
    @Column(nullable = false)
    private String agencyCertificates;
    @Column(nullable = false)
    private List<String> agencyCategory;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "agency_email")
    private AddressModel agencyAddress;
    @Column(nullable = false)
    private String agencyPassword;
}
