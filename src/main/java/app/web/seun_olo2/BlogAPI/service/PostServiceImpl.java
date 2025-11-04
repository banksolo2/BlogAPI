package app.web.seun_olo2.BlogAPI.service;

import app.web.seun_olo2.BlogAPI.entity.Post;
import app.web.seun_olo2.BlogAPI.model.ResponseMessage;
import app.web.seun_olo2.BlogAPI.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public ResponseMessage create(Post post) {
        try{
            post = postRepository.save(post);
            return ResponseMessage.builder()
                    .type("success")
                    .message("Blog created successfully")
                    .object(post)
                    .httpStatus(HttpStatus.CREATED)
                    .build();
        }
        catch(Exception ex){
            return ResponseMessage.builder()
                    .type("error")
                    .message(ex.getMessage())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @Override
    public ResponseMessage getById(Long id) {
        try {
            Post post = postRepository.findById(id).orElse(null);
            if(Objects.isNull(post)){
                return ResponseMessage.builder()
                        .type("error")
                        .message("Blog not found")
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .build();
            }

            return ResponseMessage.builder()
                    .type("success")
                    .message("Blog retrieved successfully")
                    .object(post)
                    .httpStatus(HttpStatus.OK)
                    .build();
        }
        catch(Exception ex){
            return ResponseMessage.builder()
                    .type("error")
                    .message(ex.getMessage())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @Override
    public ResponseMessage filterByTerm(String term) {
        try{
            return ResponseMessage.builder()
                    .type("success")
                    .message("Blogs retrieved successfully")
                    .object(postRepository.filterBlogs(term))
                    .httpStatus(HttpStatus.OK)
                    .build();
        }
        catch(Exception ex){
            return ResponseMessage.builder()
                    .type("error")
                    .message(ex.getMessage())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @Override
    public ResponseMessage update(Long id, Post post) {
        try{
            ResponseMessage rm = getById(id);
            if(rm.getHttpStatus() != HttpStatus.OK){
                return rm;
            }
            Post postDB = (Post) rm.getObject();
            postDB.setTitle(post.getTitle());
            postDB.setContent(post.getContent());
            postDB.setCategory(post.getCategory());
            postDB.setTags(post.getTags());
            postDB = postRepository.save(postDB);
            return ResponseMessage.builder()
                    .type("success")
                    .message("Blog updated successfully")
                    .object(postDB)
                    .httpStatus(HttpStatus.OK)
                    .build();
        }
        catch(Exception ex){
            return ResponseMessage.builder()
                    .type("error")
                    .message(ex.getMessage())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @Override
    public ResponseMessage all() {
        try{
            return ResponseMessage.builder()
                    .type("success")
                    .message("Blogs retrieved successfully")
                    .object(postRepository.findAll())
                    .httpStatus(HttpStatus.OK)
                    .build();
        }
        catch(Exception ex){
            return ResponseMessage.builder()
                    .type("error")
                    .message(ex.getMessage())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @Override
    public ResponseMessage delete(Long id) {
        try{
            ResponseMessage rm = getById(id);
            if(rm.getHttpStatus() != HttpStatus.OK){
                return rm;
            }
            postRepository.deleteById(id);
            return ResponseMessage.builder()
                    .type("success")
                    .message("Blog deleted successfully")
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }
        catch(Exception ex){
            return ResponseMessage.builder()
                    .type("error")
                    .message(ex.getMessage())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }
}
