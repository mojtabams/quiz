package ms.mojtaba.quiz.base.repository;

import ms.mojtaba.pharmacy.base.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BaseRepository<E extends BaseEntity, ID extends Number> extends JpaRepository<E, ID> {
}
