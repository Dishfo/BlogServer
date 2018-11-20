package cs.sicnu.fiveg.typehandlers;

import cs.sicnu.fiveg.pojo.UserInfo;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
public class UserIdHandler extends BaseTypeHandler<UserInfo> {



    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UserInfo parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getUserId());
    }

    @Override
    public UserInfo getNullableResult(ResultSet rs, String columnName) throws SQLException {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(rs.getInt(columnName));
        System.out.println("no");
        return userInfo;
    }

    @Override
    public UserInfo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(rs.getInt(columnIndex));
        return userInfo;
    }

    @Override
    public UserInfo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(cs.getInt(columnIndex));
        return userInfo;
    }
}
