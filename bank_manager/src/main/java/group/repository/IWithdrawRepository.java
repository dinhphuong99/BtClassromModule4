package group.repository;

import group.model.Withdraw;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWithdrawRepository extends CrudRepository<Withdraw,Long> {
}
