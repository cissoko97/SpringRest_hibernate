package app.repositoryTest;

import org.centaurus.app.config.HibernateConfig;
import org.centaurus.app.models.Comment;
import org.centaurus.app.models.Person;
import org.centaurus.app.repository.modelRepository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Set;

public class RepositoryCommentTest {

    private CommentRepository commentRepository = new CommentRepository();
    private HibernateConfig hibernateConfig = new HibernateConfig();
    private Logger logger = LoggerFactory.getLogger(RepositoryCommentTest.class);
    private Comment commentEX = new Comment();
    private Comment commentAC = new Comment();

    @BeforeEach
    public void setUp() {
        commentRepository.setSessionFactory(hibernateConfig.getSessionFactory());
    }


    @Test
    public void save() {
        Person p = new Person();
        p.setId(1);
        commentEX.setPostOn(new Date());
        commentEX.setThinking("Encore un test");
        commentEX.setPerson(p);

        commentAC.setId(5);
        commentRepository.save(commentEX);
        Assertions.assertEquals(commentEX, commentEX);

    }

    @Test
    public void findAll() {
        Set<Comment> comments = commentRepository.findAll();
        for (Comment comment : comments) {
            logger.info("comment " + comment.toString());
        }
    }

    @Test
    public void findById() {
        logger.info(commentRepository.findById(1).toString());
    }

    @Test
    public void delete() {
    }
}
