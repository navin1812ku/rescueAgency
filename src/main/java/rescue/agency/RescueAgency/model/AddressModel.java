package rescue.agency.RescueAgency.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class AddressModel {
    @Id
    private String agencyEmail;
    @Column(nullable = false)
    private String doorNumber;
    @Column(nullable = false)
    private String buildingName;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String country;
}
