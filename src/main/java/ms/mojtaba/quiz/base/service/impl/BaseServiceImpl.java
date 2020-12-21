package ms.mojtaba.quiz.base.service.impl;

import ms.mojtaba.pharmacy.base.domain.BaseEntity;
import ms.mojtaba.pharmacy.base.repository.BaseRepository;
import ms.mojtaba.pharmacy.base.service.BaseService;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<E extends BaseEntity
        , ID extends Number
        , REP extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected final REP repository;

    public BaseServiceImpl(REP repository) {
        this.repository = repository;
    }

    @Override
    public Optional<E> save(E entity) {
        try {
            return Optional.of(repository.save(entity));
        } catch (DataIntegrityViolationException ex) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<E> findOne(ID id) {
        return repository.findById(id);
    }

    @Override
    public E getOne(ID id) {
        return repository.getOne(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
