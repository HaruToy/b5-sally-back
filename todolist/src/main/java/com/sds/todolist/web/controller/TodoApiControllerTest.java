//package com.sds.todolist.web;
//
//import com.sds.todolist.web.repository.TodoRepository;
//import com.sds.todolist.web.dto.TodoDto;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.ResponseEntity;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class TodoApiControllerTest {
//    @LocalServerPort
//    private int port=8080;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private TodoRepository todoRepo;
//
//    @After
//    public void tearDown() throws Exception{
//        todoRepo.deleteAll();
//    }
//
//    @Test
//    public void TodoEnroll() throws Exception{
//        String owner="owner";
//        String content="content";
//        String status="status";
//        TodoDto requestDto=TodoDto.builder()
//                .owner(owner)
//                .content(content)
//                .status(status)
//                .build();
//
//        String url ="http://localhost:"+port+"/api/v1/tasks";
//        ResponseEntity<Long> responseEntity= restTemplate.taskfor
//
//    }
//}
