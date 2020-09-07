package com.hibernate.spring.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hibernate.spring.entity.Display;

@Repository
public class DisplayDaoImpl implements DisplayDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void add(Display display) {
    sessionFactory.getCurrentSession().save(display);

  }

  @Override
  public List<Display> listDisplays() {
    @SuppressWarnings("unchecked")
    TypedQuery<Display> query = sessionFactory.getCurrentSession().createQuery("from display");
    // 해당 문구로 쿼리를 생성할때 테이블 이름을 소문자로 하여야 인식한다. 쿼리에 대한 것은 추후 다시 공부할 예정
    return query.getResultList();
  }

}
