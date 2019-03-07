package com.init.util;

import com.init.model.entity.Stuff;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMockMVC extends AbstractMockMVC {

    public ResponseEntity<String> signup(String email, String password) {
        Stuff stuff = new Stuff();
        return post("/api/signup", stuff);
    }
}
