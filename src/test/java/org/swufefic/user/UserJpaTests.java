package org.swufefic.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.swufefic.Application;
import org.swufefic.domain.User;
import org.swufefic.domain.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserJpaTests {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {
        userRepository.deleteAll();
    }

    @Test
    public void testUserJpa() throws Exception {
        userRepository.save(new User("Leo1", 11));
        userRepository.save(new User("Leo2", 12));
        userRepository.save(new User("Leo3", 13));
        userRepository.save(new User("Leo4", 14));
        userRepository.save(new User("Leo5", 15));

        Assert.assertEquals(5, userRepository.count());

        User user = userRepository.findUser("Leo1");
        userRepository.delete(user.getId());
        Assert.assertEquals(4, userRepository.count());
    }
}
