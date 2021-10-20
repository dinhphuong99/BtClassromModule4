package group.service.withdraw;

import group.model.Transfer;
import group.model.Withdraw;
import group.repository.ITransferRepository;
import group.repository.IWithdrawRepository;
import group.service.transfer.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class WithdrawServiceImpl implements IWithdrawService {
    @Autowired
    IWithdrawRepository withdrawRepository;

    @Override
    public List<Withdraw> findAll() {
        return (List<Withdraw>) withdrawRepository.findAll();
    }

    @Override
    public void save(Withdraw withdraw) {
        withdrawRepository.save(withdraw);
    }

    @Override
    public Optional<Withdraw> findById(long id) {
        return withdrawRepository.findById(id);
    }

    @Override
    public void update(long id, Withdraw withdraw) {
    }

    @Override
    public void remove(long id) {
        withdrawRepository.deleteById(id);
    }
}
