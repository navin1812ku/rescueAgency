package rescue.agency.RescueAgency.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AddressModel {
    @Id
    private String agency_id;
    @Column(nullable = false)
    private String door_number;
    @Column(nullable = false)
    private String building_name;
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
