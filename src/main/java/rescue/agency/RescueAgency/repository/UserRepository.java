package rescue.agency.RescueAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rescue.agency.RescueAgency.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {
    UserModel findByEmail(String email);
}
