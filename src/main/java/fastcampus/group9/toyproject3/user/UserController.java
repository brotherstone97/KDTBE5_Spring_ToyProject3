package fastcampus.group9.toyproject3.user;

import fastcampus.group9.toyproject3._core.utils.ApiUtils;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/joinForm")
    public String joinForm(Model model) {
        return "/joinForm";
    }
    @PostMapping("/join")
    public String join(@Valid UserRequest.JoinDTO joinDTO, Errors errors) {
        System.out.println("controller join 실행");
        UserResponse.JoinDTO responseDTO = userService.join(joinDTO);
//        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
        return "redirect:/login";
    }
}
