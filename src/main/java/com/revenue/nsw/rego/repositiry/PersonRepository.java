package com.revenue.nsw.rego.repositiry;

import com.revenue.nsw.rego.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
}
