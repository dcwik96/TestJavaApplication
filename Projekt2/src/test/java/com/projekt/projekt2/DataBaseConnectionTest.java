package com.projekt.projekt2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DataBaseConnectionTest {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Value("${spring.datasource.url}")
    String url;

    @Test
    public void checkIfPropertiesUrlPutCorrectly() throws SQLException {
        Connection c = DriverManager.getConnection(url);
        assertThat(c.getCatalog()).isNotNull()
                .isEqualToIgnoringCase("public");
    }

    @Test
    public void checkIfErrorWhenUrlWrong() {
        assertThrows(SQLException.class, () -> DriverManager.getConnection("wrongurl"));
    }

}
