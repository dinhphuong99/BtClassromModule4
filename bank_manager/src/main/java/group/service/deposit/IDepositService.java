package group.service.deposit;

import group.model.Deposit;

import java.util.List;
import java.util.Optional;

public interface IDepositService {
    List<Deposit> findAll();

    void save(Deposit deposit);

    Optional<Deposit> findById(long id);

    void update(long id, Deposit deposit);

    void remove(long id);
}
