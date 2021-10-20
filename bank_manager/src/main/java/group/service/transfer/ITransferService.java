package group.service.transfer;

import group.model.Transfer;

import java.util.List;
import java.util.Optional;

public interface ITransferService {
    List<Transfer> findAll();

    void save(Transfer transfer);

    Optional<Transfer> findById(long id);

    void update(long id, Transfer transfer);

    void remove(long id);
}
