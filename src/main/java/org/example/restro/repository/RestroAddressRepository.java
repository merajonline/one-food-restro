package org.example.restro.repository;

import org.example.restro.model.RestroAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RestroAddressRepository extends JpaRepository<RestroAddress, Long> {

    //@Query("SELECT * FROM RestroAddress u WHERE u.id = :id")
    @Query(value = "SELECT * FROM restro_address u WHERE u.id = :id", nativeQuery = true)
    RestroAddress fetchById(@Param("id") Long id);

}
