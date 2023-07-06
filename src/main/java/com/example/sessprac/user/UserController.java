package com.example.sessprac.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final StringRedisTemplate stringRedisTemplate;
    private final UserService userService;

    @PostMapping("/join")
    public UserJoinDTO joinUser(@RequestBody UserJoinDTO userDto, HttpSession session) {
        UserJoinDTO userResponse = userService.joinUser(userDto);
        session.setAttribute("session", userDto.getUserId());
        return userResponse;
    }

    @GetMapping("/login")
    public void loginUser(@RequestParam String userId, HttpSession session) {
        session.setAttribute("session", userId);
    }

    @DeleteMapping("/logout")
    public void logOut(HttpSession session) {
        session.removeAttribute("session");
        session.invalidate();
    }

    @GetMapping("/me")
    public void getMe(HttpSession session) {
//        System.out.println(session.getId());
//        System.out.println(session.getAttribute("session"));
        System.out.println("memememe");
    }

    @GetMapping("/user")
    public UserJoinDTO getUser(@RequestParam("userName") String userName) {
        UserJoinDTO user = new UserJoinDTO();
        user.setUserId("1234");
//        user.setName("홍민정");
//        user.setPassword("qwerty");

        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            /**
             * User object -> String으로 저장
             */
            String str = objectMapper.writeValueAsString(user);
            valueOperations.set("str", str);

            /**
             * Redis에서 String으로 가져온 값 -> User로 파싱
             */
            String str2 = valueOperations.get("str");
            UserJoinDTO myUser = objectMapper.readValue(str2, UserJoinDTO.class);

            return myUser;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
