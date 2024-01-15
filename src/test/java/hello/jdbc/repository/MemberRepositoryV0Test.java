package hello.jdbc.repository;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.NoSuchElementException;

@Slf4j
class MemberRepositoryV0Test {
    MemberRepositoryV0 repository = new MemberRepositoryV0();
    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberV30", 30000);
        repository.save(member);

        //find
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember={}",findMember);
        Assertions.assertThat(findMember).isEqualTo(member);

        //update
        repository.update(member.getMemberId(), 1000);
        Member updateMember = repository.findById(member.getMemberId());
        Assertions.assertThat(updateMember.getMoney()).isEqualTo(1000);

        //delete
        repository.delete(member.getMemberId());
        Assertions.assertThatThrownBy(() -> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }
}