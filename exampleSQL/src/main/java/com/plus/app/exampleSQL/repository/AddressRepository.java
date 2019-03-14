package com.plus.app.exampleSQL.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.plus.app.exampleSQL.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{

}
