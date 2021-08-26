package com.enroutesystems;

import com.enroutesystems.yugioh.DataSourceInitialization;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleTypes;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.*;


@Slf4j
public class JdbcTest {

    @Test
    public void testJDBCConexion(){
        DataSourceInitialization dataSourceInitialization = new DataSourceInitialization();
        DataSource dataSource = dataSourceInitialization.getDataSource();
        try {
            Connection connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info(dataSource.toString());
    }

    @Test
    public void testJDBCStatement()  {
        DataSourceInitialization  dataSourceInitialization = new DataSourceInitialization();
        DataSource dataSource = dataSourceInitialization.getDataSource();
        Connection connection=null;
        ResultSet resultSet=null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select TO_CHAR(sysdate) fechaActual from dual");
            resultSet.next();
            String result = resultSet.getString("fechaActual");
            log.info(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            }catch(SQLException e){
                log.info("Error en la conexion.");
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            }catch(SQLException e){
                log.info("Error en la conexion.");
            }
        }
        log.info(dataSource.toString());
    }

    @Test
    public void testJDBCPreparedStament(){
        DataSourceInitialization  dataSourceInitialization = new DataSourceInitialization();
        DataSource dataSource = dataSourceInitialization.getDataSource();
        Connection connection=null;
        try {
            String sql = "select t_nombre nombre from carta where c_id=?";
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,3);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                String result = resultSet.getString("nombre");
                log.info(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }catch(SQLException e){
                log.info("Error en la conexion.");
            }
        }
        log.info(dataSource.toString());
    }


    @Test
    public void testJDBCPreparedStamentUpdate(){
        DataSourceInitialization  dataSourceInitialization = new DataSourceInitialization();
        DataSource dataSource = dataSourceInitialization.getDataSource();
        Connection connection=null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps=null;
            for(int i=0;i<100000;i++) {
                String sql = "update  carta  set t_nombre = 'M@go Oscuro' where c_id=?";
                ps = connection.prepareStatement(sql);
                ps.setLong(1, 3);
                ps.addBatch();
            }
            ps.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }catch(SQLException e){
                log.info("Error en la conexion.");
            }
        }
        log.info(dataSource.toString());
    }


    @Test
    public void testJDBCCallableStament(){
        DataSourceInitialization  dataSourceInitialization = new DataSourceInitialization();
        DataSource dataSource = dataSourceInitialization.getDataSource();
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            CallableStatement cs=null;
            String sql = "begin pkg_carta_yugi.spapt_carta(?,?); end;";
            cs = connection.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2,Types.INTEGER);
            cs.execute();
            resultSet = (ResultSet) cs.getObject(1);
            while(resultSet.next()){
                log.info(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            }catch(SQLException e){
                log.info("Error en la conexion.");
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            }catch(SQLException e){
                log.info("Error en la conexion.");
            }
        }
    }


    @Test
    public void testJDBCResultSetMetaData(){
        DataSourceInitialization  dataSourceInitialization = new DataSourceInitialization();
        DataSource dataSource = dataSourceInitialization.getDataSource();
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            CallableStatement cs=null;
            String sql = "begin pkg_carta_yugi.spapt_carta(?,?); end;";
            cs = connection.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setInt(2,Types.INTEGER);
            cs.execute();
            resultSet = (ResultSet) cs.getObject(1);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            for(int i=1;i<=columns;i++){
                String columnName = metaData.getColumnName(i);
                String columnTypeName = metaData.getColumnTypeName(i);
                log.info("Column namve:"+columnName+",typeName:"+columnTypeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            }catch(SQLException e){
                log.info("Error en la conexion.");
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            }catch(SQLException e){
                log.info("Error en la conexion.");
            }
        }
    }

}
