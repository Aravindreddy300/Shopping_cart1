package com.shop.dtotests;


import org.junit.jupiter.api.Test;

import com.shop.payload.LoginDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginDtoTest {

    @Test
    public void testLoginDto() {
        // Create a mock object for LoginDto
        LoginDto loginDtoMock = mock(LoginDto.class);

        // Set expectations on the mock object
        when(loginDtoMock.getUsernameOrEmail()).thenReturn("testUser");
        when(loginDtoMock.getPassword()).thenReturn("testPassword");

        // Perform tests using the mock object
        assertEquals("testUser", loginDtoMock.getUsernameOrEmail());
        assertEquals("testPassword", loginDtoMock.getPassword());
    }
}

