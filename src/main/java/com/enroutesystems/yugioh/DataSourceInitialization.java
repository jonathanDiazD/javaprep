package com.enroutesystems.yugioh;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;

@Component
public class DataSourceInitialization {


    private DataSource dataSource;

    private final String url = "jdbc:oracle:thin:@127.0.0.1:1521/ORCLCDB.localdomain";
    private final String user = "SYS AS SYSDBA";
    private final String password = "Oradoc_db1";

    public DataSource getDataSource(){
        if(dataSource==null) {
            dataSource = DataSourceBuilder.create().url(url).username(user).password(password).build();
        }
        return dataSource;
    }

}
