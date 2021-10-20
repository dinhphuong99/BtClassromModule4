package group.service.withdraw;

import group.model.Withdraw;
import java.util.List;
import java.util.Optional;

public interface IWithdrawService {
    List<Withdraw> findAll();

    void save(Withdraw withdraw);

    Optional<Withdraw> findById(long id);

    void update(long id, Withdraw withdraw);

    void remove(long id);
}
