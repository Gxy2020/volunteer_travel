package yqc.volunteer_travel.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yqc.volunteer_travel.model.TravelRoute;
import yqc.volunteer_travel.model.User;
import yqc.volunteer_travel.model.UserRoute;

import java.util.List;

@Repository
public interface UserRouteRepository extends JpaRepository<UserRoute, String>, JpaSpecificationExecutor<UserRoute> {

    List<UserRoute> findUserRouteByUser(User user);

    UserRoute findUserRouteByTravelRouteAndUser(TravelRoute travelRoute, User user);
}
