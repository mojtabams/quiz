package ms.mojtaba.quiz.base.service;

import ms.mojtaba.pharmacy.base.domain.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity, ID extends Number> {

    Optional<E> save(E entity);

    Optional<E> findOne(ID id);

    E getOne(ID id);

    List<E> findAll();

    void delete(ID id);
}
