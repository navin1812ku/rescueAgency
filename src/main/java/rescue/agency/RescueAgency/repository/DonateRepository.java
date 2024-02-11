package rescue.agency.RescueAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rescue.agency.RescueAgency.model.DonateModel;

@Repository
public interface DonateRepository extends JpaRepository<DonateModel,String> {
}
