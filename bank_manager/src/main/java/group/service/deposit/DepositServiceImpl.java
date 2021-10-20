package group.service.deposit;

import group.model.Customer;
import group.model.Deposit;
import group.repository.ICustomerRepository;
import group.repository.IDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DepositServiceImpl implements IDepositService {
    @Autowired
    IDepositRepository depositRepository;

    @Override
    public List<Deposit> findAll() {
        return (List<Deposit>) depositRepository.findAll();
    }

    @Override
    public void save(Deposit deposit) {
        depositRepository.save(deposit);
    }

    @Override
    public Optional<Deposit> findById(long id) {
        return depositRepository.findById(id);
    }

    @Override
    public void update(long id, Deposit deposit) { }

    @Override
    public void remove(long id) {
        depositRepository.deleteById(id);
    }
}
