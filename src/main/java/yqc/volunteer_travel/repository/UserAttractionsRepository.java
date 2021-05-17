package yqc.volunteer_travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yqc.volunteer_travel.model.Attractions;
import yqc.volunteer_travel.model.User;
import yqc.volunteer_travel.model.UserAttractions;

import java.util.List;

public interface UserAttractionsRepository extends JpaRepository<UserAttractions, String>, JpaSpecificationExecutor<UserAttractions> {

    List<UserAttractions> findUserAttractionsByUser(User user);

    UserAttractions findUserAttractionsByAttractionsAndUser(Attractions attractions, User user);
}
