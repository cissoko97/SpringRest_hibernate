package org.centaurus.app.restservice;

import org.centaurus.app.models.Comment;
import org.centaurus.app.repository.modelRepository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @GetMapping
    public Set<Comment> findAll() {
        return commentRepository.findAll();
    }
}
