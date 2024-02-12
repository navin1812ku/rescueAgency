package rescue.agency.RescueAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rescue.agency.RescueAgency.model.RequestModel;

@Repository
public interface RequestRepository extends JpaRepository<RequestModel,String> {
    RequestModel findByRequestMemberId(String id);
}
