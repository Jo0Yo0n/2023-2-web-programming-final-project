package jdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


import test.Identifiable;

public class DaoTemplate<Obj> {
    private Connection connection;
    /**
     * ConnectionManager에 mysql 기본 설정으로 connection 생성 
     */
    public DaoTemplate() {
    	try {
            this.connection = ConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * url, userName, password를 직접 입력하여 connection 생성
     * @param url
     * @param userName
     * @param password
     */
    public DaoTemplate(String url, String userName, String password) {
        try {
            this.connection = ConnectionManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 객체의 id를 자동으로 생성해주고 sql을 실행하여 insert를 수행
     * id 자동 생성을 위해선 Entity Object가 Identifiable를 구현한 클래스여야함.
     * @param sql
     * @param object
     * @param args
     * @return
     * @throws SQLException
     */
    public Long insert(String sql, Obj object, Object... args) throws SQLException {
        Long rowsAffected = 0L;
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // 인자 바인딩
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.executeUpdate();

            // 삽입된 행의 ID 가져오기
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                Obj firstArg = object;
                if (firstArg instanceof Identifiable) {
                    Identifiable identifiable = (Identifiable) firstArg;
                    rowsAffected = generatedKeys.getLong(1);
                    identifiable.setId(rowsAffected); // 자동 생성된 키를 객체에 설정
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }
    /**
     * id를 이용해 검색하고 T에 맞게 mapping 하기 위해 mapper.apply를 이용해 실행하는 쪽에서 매핑하도록 유도함.
     * @param <T>
     * @param sql
     * @param mapper
     * @param args
     * @return
     * @throws SQLException
     */
    public <T> T queryForObject(String sql, Function<ResultSet, T> mapper, Object... args) throws SQLException {
        T result = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            // 인자 바인딩
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            try (ResultSet rs = ps.executeQuery()) {
               
                result = mapper.apply(rs);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * select를 실행할 때 여러 개의 값이 나오는 경우 사용.
     * join 등도 사용할 수 있음.
     * @param sql
     * @param rowMapper
     * @param args
     * @return
     * @throws SQLException
     */
    public List<Obj> queryForList(String sql, RowMapper<Obj> rowMapper, Object... args) throws SQLException {
        List<Obj> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            // 인자 바인딩
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultList.add(rowMapper.mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
    /**
     * 업데이트를 실행하고 user id를 반환함.
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    public Long update(String sql, Object... args) throws SQLException {
        Long rowsAffected = 0L;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            // 인자 바인딩
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rowsAffected = (long)ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }
    
    /**
     * 삭제함.
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    public Long delete(String sql, Object... args) throws SQLException {
        Long rowsAffected = 0L;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            // 인자 바인딩
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rowsAffected = (long)ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }
    // 기본적인 RowMapper 인터페이스
    public interface RowMapper<T> {
        T mapRow(ResultSet rs) throws SQLException;
    }
}
