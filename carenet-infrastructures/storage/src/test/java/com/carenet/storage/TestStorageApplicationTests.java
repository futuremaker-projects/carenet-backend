package com.carenet.storage;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootApplication(scanBasePackages = {
        "com.carenet.admin", "com.carenet.storage"
})
public class TestStorageApplicationTests {
}
