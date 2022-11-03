package com.sds.todolist.web.controller;

import com.sds.todolist.web.service.TodoService;
import com.sds.todolist.web.domain.Task;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TodoApiController {

    private final TodoService todoService;

    public TodoApiController(TodoService TodoService) {
        this.todoService = TodoService;
    }
    @PostMapping("/tasks")
    public Task save(@RequestBody Task requestDto) {
        return todoService.createTodo(requestDto);
    }
    @ApiOperation(value = "일감 조회", notes = "일감 정보를 조회한다.")
    @GetMapping(value = "/tasks")
    public List<Task> taskInfo() throws IllegalAccessException {
//        List<Task> member = todoService.getTodos();
//        return new ResponseEntity<List<Task>>(member, HttpStatus.OK);
        return todoService.getTodos();
    }
    @PostMapping("/tasks/{id}")
    public Long update(@PathVariable Long id, @RequestBody Task requestDto) {
        return todoService.update(id, requestDto);
    }
    @PostMapping("/create")
    public ResponseEntity<Task> create(@RequestBody Task task) {
        return ResponseEntity.ok()
                .body(todoService.createTodo(task));
    }
}

//@Api(tags = {"3. Board"})
//@RequiredArgsConstructor
//@RestController
//@RequestMapping(value = "/v1/board")
//public class BoardController {
//
//    private final BoardService boardService;
//    private final ResponseService responseService;
//
//    @ApiOperation(value = "게시판 정보 조회", notes = "게시판 정보를 조회한다.")
//    @GetMapping(value = "/{boardName}")
//    public SingleResult<Board> boardInfo(@PathVariable String boardName) {
//        return responseService.getSingleResult(boardService.findBoard(boardName));
//    }
//
//    @ApiOperation(value = "게시판 글 리스트", notes = "게시판 게시글 리스트를 조회한다.")
//    @GetMapping(value = "/{boardName}/posts")
//    public ListResult<Post> posts(@PathVariable String boardName) {
//        return responseService.getListResult(boardService.findPosts(boardName));
//    }
//
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
//    })
//    @ApiOperation(value = "게시판 글 작성", notes = "게시판에 글을 작성한다.")
//    @PostMapping(value = "/{boardName}")
//    public SingleResult<Post> post(@PathVariable String boardName, @Valid @ModelAttribute ParamsPost post) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String uid = authentication.getName();
//        return responseService.getSingleResult(boardService.writePost(uid, boardName, post));
//    }
//
//    @ApiOperation(value = "게시판 글 상세", notes = "게시판 글 상세정보를 조회한다.")
//    @GetMapping(value = "/post/{postId}")
//    public SingleResult<Post> post(@PathVariable long postId) {
//        return responseService.getSingleResult(boardService.getPost(postId));
//    }
//
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
//    })
//    @ApiOperation(value = "게시판 글 수정", notes = "게시판의 글을 수정한다.")
//    @PutMapping(value = "/post/{postId}")
//    public SingleResult<Post> post(@PathVariable long postId, @Valid @ModelAttribute ParamsPost post) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String uid = authentication.getName();
//        return responseService.getSingleResult(boardService.updatePost(postId, uid, post));
//    }
//
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
//    })
//    @ApiOperation(value = "게시판 글 삭제", notes = "게시판의 글을 삭제한다.")
//    @DeleteMapping(value = "/post/{postId}")
//    public CommonResult deletePost(@PathVariable long postId) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String uid = authentication.getName();
//        boardService.deletePost(postId, uid);
//        return responseService.getSuccessResult();
//    }
//}