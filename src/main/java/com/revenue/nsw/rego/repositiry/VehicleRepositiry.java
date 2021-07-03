package com.revenue.nsw.rego.repositiry;

import com.revenue.nsw.rego.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepositiry extends CrudRepository<Vehicle, Long> {

    Vehicle findByRegoNumber(String regoNumber);

}
