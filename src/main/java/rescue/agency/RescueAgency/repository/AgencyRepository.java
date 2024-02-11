package rescue.agency.RescueAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rescue.agency.RescueAgency.model.AgencyModel;

import java.util.List;

@Repository
public interface AgencyRepository extends JpaRepository<AgencyModel,String> {
//    @Query("SELECT a FROM address_model a WHERE " +
//            "a.street = :location OR " +
//            "a.city = :location OR " +
//            "a.district = :location OR " +
//            "a.state = :location OR " +
//            "a.country = :location")
    List<AgencyModel> searchByAgencyAddress(String location);
    AgencyModel findByAgencyId(String id);
    List<AgencyModel> searchByAgencyExpertise(String expertise);
}
