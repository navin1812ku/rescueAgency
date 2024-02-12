package rescue.agency.RescueAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rescue.agency.RescueAgency.model.AgencyModel;

import java.util.List;

@Repository
public interface AgencyRepository extends JpaRepository<AgencyModel,String> {
    @Query("SELECT a FROM AgencyModel a JOIN a.agencyAddress address WHERE " +
            "address.street = :location OR " +
            "address.city = :location OR " +
            "address.district = :location OR " +
            "address.state = :location OR " +
            "address.country = :location")
    List<AgencyModel> findByAgencyAddress(@Param("location") String location);

    AgencyModel findByAgencyEmail(String id);

    @Query("SELECT a FROM AgencyModel a WHERE :value IN(a.agencyExpertise)")
    List<AgencyModel> findByAgencyExpertiseContaining(@Param("value") String expertise);
}
