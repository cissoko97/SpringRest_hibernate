package org.centaurus.app.repository.modelRepository.IRepositoy;

import org.centaurus.app.models.Comment;
import org.centaurus.app.models.Person;

import java.util.Set;

public interface ICommentRepository {
    Set<Comment> findByPerson(Person person);

    void deleteByPerson(Person person);
}
