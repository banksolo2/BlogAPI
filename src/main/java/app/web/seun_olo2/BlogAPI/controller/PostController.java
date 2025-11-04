package app.web.seun_olo2.BlogAPI.controller;

import app.web.seun_olo2.BlogAPI.entity.Post;
import app.web.seun_olo2.BlogAPI.model.ResponseMessage;
import app.web.seun_olo2.BlogAPI.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    private final PostService postService;
    private ResponseMessage rm;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Post post){
        rm = postService.create(post);
        if(rm.getType().equals("error")){
            return new ResponseEntity<>(rm.getMessage(), rm.getHttpStatus());
        }
        return new ResponseEntity<>(rm.getObject(), rm.getHttpStatus());
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        rm = postService.all();
        return new ResponseEntity<>(rm.getObject(), rm.getHttpStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        rm = postService.getById(id);
        if(rm.getType().equals("error")){
            return new ResponseEntity<>(rm.getMessage(), rm.getHttpStatus());
        }
        return new ResponseEntity<>(rm.getObject(), rm.getHttpStatus());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody Post post){
        rm = postService.update(id, post);
        if(rm.getType().equals("error")){
            return new ResponseEntity<>(rm.getMessage(), rm.getHttpStatus());
        }
        return new ResponseEntity<>(rm.getObject(), rm.getHttpStatus());
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterByTerm(@RequestParam("term")String term){
        rm = postService.filterByTerm(term);
        if(rm.getType().equals("error")){
            return new ResponseEntity<>(rm.getMessage(), rm.getHttpStatus());
        }
        return new ResponseEntity<>(rm.getObject(), rm.getHttpStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        rm = postService.delete(id);
        return new ResponseEntity<>(rm.getMessage(), rm.getHttpStatus());
    }
}
