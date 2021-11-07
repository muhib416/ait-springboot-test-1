package com.example.springbootcrud.example;



 


import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.example.springbootcrud.example.controller.UserController;
import com.example.springbootcrud.example.entity.User;
import com.example.springbootcrud.example.entity.UserDummy;
import com.example.springbootcrud.example.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.*;

 

import java.io.IOException;
import java.util.List;

import util.BaseResponse;

 

@RunWith(MockitoJUnitRunner.class)

public class UserControllerTest {

              @InjectMocks

              UserController controller;

 
              @Mock

              UserService service;


              util.BaseResponse baseResponse;

              ResponseEntity<util.BaseResponse> response;

 

              @BeforeAll

              public void setup() {

                             baseResponse = new util.BaseResponse();

                             response = ResponseEntity.ok().body(baseResponse);

              }

 

              @Test

              public void submitSearchUser() throws IOException {

                             String name = "User Name";
                             User user = new User();
                             user.setName("User Name");

                             when(service.getUserByName(name)).thenReturn((List<User>) response);
                             Model model = null;
 

                             @SuppressWarnings("unchecked")

                             String responseCase = (String) controller.submitSearchUser(user, model);

                             assertNotNull(responseCase);

              }

 

              @Test
              public void showUser() throws IOException {

            	  String name = "User Name";
                  User user = new User();
                  user.setName("User Name");

                  when(service.getUser()).thenReturn((List<User>) response);
                  Model model = null;


                  @SuppressWarnings("unchecked")

                  String responseCase = (String) controller.showUser(model);

                  assertNotNull(responseCase);

              }

 

              @Test

              public void caseSave() throws IOException {

            	  UserDummy user = new UserDummy();
                  user.setName("User Name");
                  user.setHp("082277383839");
                  user.setEmail("muhib@gmail.com");
                  
                  User users = new User();
                  users.setName("User Name");
                  users.setHp("082277383839");
                  users.setEmail("muhib@gmail.com");

                  when(service.saveUser(users)).thenReturn(users);
                  Model model = null;


                  @SuppressWarnings("unchecked")

                  String responseCase = (String) controller.submitForm(user);

                  assertNotNull(responseCase);

              }

}