package rescue.agency.RescueAgency.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "agency")
@Data
public class AgencyModel {
    @Id
    private String agency_id;
    @Column(nullable = false)
    private String agency_name;
    @Column(nullable = false)
    private String agency_contact;
    @Column(nullable = false)
    private List<String> agency_expertise;
    @Column(nullable = false)
    private String agency_certificates;
    @Column(nullable = false)
    private List<String> agency_category;
    @Column(nullable = false)
    @JoinColumn(name = "agency_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressModel> agency_address;
    @Column(nullable = false)
    private String agency_password;
}
