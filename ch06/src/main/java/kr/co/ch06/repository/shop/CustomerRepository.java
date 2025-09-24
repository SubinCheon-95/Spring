package kr.co.ch06.repository.shop;

import kr.co.ch06.entity.shop.Customer;
import kr.co.ch06.repository.shop.custom.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, CustomerRepositoryCustom {
}
