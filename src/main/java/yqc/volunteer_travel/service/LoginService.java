package yqc.volunteer_travel.service;

import yqc.volunteer_travel.core.Result;
import yqc.volunteer_travel.core.ResultGenerator;
import yqc.volunteer_travel.model.User;
import yqc.volunteer_travel.repository.UserRepository;
import yqc.volunteer_travel.util.CookieUitl;
import yqc.volunteer_travel.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public Result login(User user, HttpServletResponse response) {
        User userByUsername = userRepository.findUserByUsername(user.getUsername());
        if (userByUsername == null) {
            return ResultGenerator.genFailResult("用户名错误!");
        } else {
            if (user.getPassword().equals(userByUsername.getPassword())) {
                Cookie cookie = new Cookie("username", user.getUsername());
                cookie.setPath("/");
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult("密码错误!");
            }
        }

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUitl.get(request, "username");
        if(cookie != null){
            CookieUitl.set(response,"username",null,0);
        }
  }

    public Result register(User user) {
        User userByUsername = userRepository.findUserByUsername(user.getUsername());
        if(userByUsername != null){
            return ResultGenerator.genFailResult("用户名重复!");
        }
        //Todo 这里有一个事务操作
        user.setId(IdGenerator.id());
        userRepository.save(user);
        return ResultGenerator.genSuccessResult();
    }
}
