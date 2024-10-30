package uz.keysoft.processmodules.committeevote.jpapostgresadapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.keysoft.processmodules.committeevote.jpapostgresadapter.entity.imps.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
