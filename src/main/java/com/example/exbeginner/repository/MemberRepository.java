package com.example.exbeginner.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.exbeginner.model.Member;

@Repository
public class MemberRepository {
  @Autowired
  private NamedParameterJdbcTemplate template;
  private static final String SEARCH_SQL = """
    SELECT name, age, dep_id
      FROM members
        WHERE name LIKE '%""";
  private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
    Member member = new Member();
    member.setName(rs.getString("name"));
    member.setAge(rs.getInt("age"));
    member.setDep_id(rs.getInt("dep_id"));

    return member;
  };

  /**
   * 曖昧検索を行う.
   * 
   * @return Memberリスト.
   */
  public List<Member> ambiguousSearch(String keyword){
    StringBuilder builder = new StringBuilder();
    builder.append(SEARCH_SQL).append(keyword).append("%';");
    
    List<Member> member_list = template.query(builder.toString(), MEMBER_ROW_MAPPER);

    System.out.println(builder.toString());
    return member_list;
  }
  
}
