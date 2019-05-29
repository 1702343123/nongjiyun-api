package cn.niit.group5.controller;

import cn.niit.group5.entity.dto.UserDTO;
import cn.niit.group5.mapper.BasicTest;
import cn.niit.group5.util.ResponseResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserControllerTest extends BasicTest {

    @Autowired
    UserController userController;
    @Test
    public void signIn() {
        UserDTO userDTO=new UserDTO();
        userDTO.setPassword("JAVA22");
        userDTO.setPhoneNumber("17805136692");
        ResponseResult responseResult = userController.signIn(userDTO);
        System.out.println(responseResult.toString());

    }
}