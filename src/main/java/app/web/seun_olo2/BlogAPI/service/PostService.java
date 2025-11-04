package app.web.seun_olo2.BlogAPI.service;

import app.web.seun_olo2.BlogAPI.entity.Post;
import app.web.seun_olo2.BlogAPI.model.ResponseMessage;

public interface PostService {

    public ResponseMessage create(Post post);

    public ResponseMessage getById(Long id);

    public ResponseMessage filterByTerm(String term);

    public ResponseMessage update(Long id, Post post);

    public ResponseMessage all();

    public ResponseMessage delete(Long id);
}
