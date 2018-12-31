package org.centaurus.app.repository.modelRepository.IRepositoy;

import org.centaurus.app.models.Person;
import org.jboss.logging.annotations.Param;

public interface IPersonRepository {

    Person findByEmailAndPassword(String email, String password);

    void deleteByEmailAndPassword(String email, String password);

    Boolean ifExist(String email , String password);
}
