package com.hibernate.spring.entity.subsidiary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubsidiaryRepository extends JpaRepository<Subsidiary, String> {

  Subsidiary findBySubsiName(String subsiName);

}
