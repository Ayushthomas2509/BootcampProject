package ayushproject.ayushecommerce.repo;

import ayushproject.ayushecommerce.entities.VerificationToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VerificationTokenRepo extends CrudRepository<VerificationToken,Integer> {

    @Query(value = "select tokenId from VerificationToken where token=:token",nativeQuery = true)
    VerificationToken getByToken(@Param("token") String token);
}
