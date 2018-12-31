package org.centaurus.app.repository.modelRepository;

import org.centaurus.app.models.Comment;
import org.centaurus.app.models.Person;
import org.centaurus.app.repository.Repository;
import org.centaurus.app.repository.modelRepository.IRepositoy.ICommentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;

@Component
public class CommentRepository extends Repository<Comment, Integer> implements ICommentRepository {

    @Override
    public Set<Comment> findByPerson(Person person) {
        return null;
    }

    @Override
    public void deleteByPerson(Person person) {

    }
}
