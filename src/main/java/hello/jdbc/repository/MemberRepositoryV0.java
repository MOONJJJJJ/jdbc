package hello.jdbc.repository;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public class MemberRepositoryV0 {
    public Member save(Member member){
        String sql = "insert into member(member_id, money) values (?, ?)";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2,member.getMoney());
            return member;
        } catch (SQLException e){
            log.error("db error", e);
            throw e;
        }finally {
            pstmt.close();
            con.close();
        }
    }
    private Connection getConnection(){
        return DBConnectionUtil.getConnection();
    }
}
