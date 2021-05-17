package yqc.volunteer_travel.repository;

import yqc.volunteer_travel.model.Attractions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface AttractionsRepository extends JpaRepository<Attractions, String>, JpaSpecificationExecutor<Attractions> {

}