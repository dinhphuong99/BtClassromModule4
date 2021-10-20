package group.service.transfer;

import group.model.Transfer;
import group.repository.ITransferRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TransferServiceImpl implements ITransferService {
    @Autowired
    ITransferRepository transferRepository;

    @Override
    public List<Transfer> findAll() {
        return (List<Transfer>) transferRepository.findAll();
    }

    @Override
    public void save(Transfer transfer) {
        transferRepository.save(transfer);
    }

    @Override
    public Optional<Transfer> findById(long id) {
        return transferRepository.findById(id);
    }

    @Override
    public void update(long id, Transfer transfer) { }

    @Override
    public void remove(long id) {
        transferRepository.deleteById(id);
    }
}
