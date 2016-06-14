package org.rainzha.practicalunittesting.exercises.chapter05;


import org.junit.Test;

import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    private static final String PASSWORD_MD5 = "123456";

    @Test
    public void assignNewPasswordToUser() throws Exception {
        UserDAO userDAO = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);
        User user = mock(User.class);

        UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);

        when(securityService.md5(user.getPassword())).thenReturn(PASSWORD_MD5);

        userService.assignPassword(user);

        verify(userDAO).updateUser(user);
    }
}