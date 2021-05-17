package yqc.volunteer_travel;

import yqc.volunteer_travel.model.TravelRoute;
import yqc.volunteer_travel.repository.TravelRouteRepository;
import yqc.volunteer_travel.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VolunteerTravelApplicationTests {
     @Autowired
    TravelRouteRepository travelRouteRepository;
     @Autowired
     RedisTemplate<String, Object> redisTemplate;
    @Autowired
    RedisUtil redis;
    @Test
    public void contextLoads() {

        List<TravelRoute> all = travelRouteRepository.findAll();
        for(TravelRoute route : all){
            redisTemplate.opsForHash().put(route.getId(),"路线名",route.getName());
            redisTemplate.opsForHash().put(route.getId(),"路线描述",route.getDescribe());
            redisTemplate.opsForHash().put(route.getId(),"路线创建日期",route.getCreateDate());
        }

        Set<String> keys = redisTemplate.keys("*");
        for(String key :keys){
            Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
            for(Map.Entry<Object, Object> entry :entries.entrySet()){
                System.out.println(entry.getKey()+"==="+entry.getValue());
            }
        }

    }

}
