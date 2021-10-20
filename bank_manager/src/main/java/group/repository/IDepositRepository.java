package group.repository;

import group.model.Deposit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepositRepository extends CrudRepository<Deposit,Long> {
}
