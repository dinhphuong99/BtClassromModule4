package group.repository;

import group.model.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferRepository extends CrudRepository<Transfer,Long> {
}
