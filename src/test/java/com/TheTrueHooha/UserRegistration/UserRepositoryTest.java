package com.TheTrueHooha.UserRegistration;

import com.TheTrueHooha.UserRegistration.Repository.UserRepository;
import com.TheTrueHooha.UserRegistration.User.UserParameters;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testCreateNewUser () {
        UserParameters userParameters = new UserParameters();
        userParameters.setEmail("ogun@Gmail.com");
        userParameters.setPassword("22222222222222222222");
        userParameters.setPhoneNumber("08025541323");
        userParameters.setUserName("ogunboy4real");
        userParameters.setFirstName("Ogun");
        userParameters.setLastName("ogun");

        UserParameters savedUser = userRepository.save(userParameters);
        UserParameters existingUser = entityManager.find(UserParameters.class, savedUser.getId());

        assertThat(existingUser.getEmail()).isEqualTo(userParameters.getEmail());

    }

}
