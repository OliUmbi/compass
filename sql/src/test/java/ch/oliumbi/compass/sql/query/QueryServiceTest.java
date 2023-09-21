package ch.oliumbi.compass.sql.query;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueryServiceTest {

  /**
  private QueryService queryService;

  @BeforeEach
  void setUp() {
    queryService = new QueryService();
  }

  @Test
  void select() {
    Query query = queryService.parse("""
        SELECT  id,
                name,
                password,
                role
        FROM    person
        WHERE   role = :role
        ORDER BY name
        OFFSET  :start
        LIMIT   :size
        INTO    id,
                name,
                password,
                role.name
        """);

    assertEquals("""
        SELECT  id,
                name,
                password,
                role
        FROM    person
        WHERE   role = ?
        ORDER BY name
        OFFSET  ?
        LIMIT   ?
        """, query.executable());

    assertEquals(List.of("role", "start", "size"), query.inputs());
    assertEquals(List.of("id", "name", "password", "role.name"), query.outputs());
  }

  @Test
  void insert() {
    Query query = queryService.parse("""
        INSERT INTO person (
                id,
                name,
                password,
                role)
        VALUES (
                :id,
                :name,
                crypt(:password, gen_salt('md5')),
                :role)
        """);

    assertEquals("""
        INSERT INTO person (
                id,
                name,
                password,
                role)
        VALUES (
                ?,
                ?,
                crypt(?, gen_salt('md5')),
                ?)
        """, query.executable());

    assertEquals(List.of("id", "name", "password", "role"), query.inputs());
    assertEquals(0, query.outputs().size());
  }

  @Test
  void update() {
    Query query = queryService.parse("""
        UPDATE  person
        SET     name = :name,
                password = :password,
                role = :role
        WHERE   id = :id
        AND     is_deleted = FALSE
        """);

    assertEquals("""
        UPDATE  person
        SET     name = ?,
                password = ?,
                role = ?
        WHERE   id = ?
        AND     is_deleted = FALSE
        """, query.executable());

    assertEquals(List.of("name", "password", "role", "id"), query.inputs());
    assertEquals(0, query.outputs().size());
  }

  @Test
  void delete() {
    Query query = queryService.parse("""
        DELETE FROM person
        WHERE id = :id
        """);

    assertEquals("""
        DELETE FROM person
        WHERE id = ?
        """, query.executable());

    assertEquals(List.of("id"), query.inputs());
    assertEquals(0, query.outputs().size());
  }

  @Test
  void exists() {
    Query query = queryService.parse("""
        SELECT EXISTS (
                SELECT  1
                FROM    person
                WHERE   id = :id)
        """);

    assertEquals("""
        SELECT EXISTS (
                SELECT  1
                FROM    person
                WHERE   id = ?)
        """, query.executable());

    assertEquals(List.of("id"), query.inputs());
    assertEquals(0, query.outputs().size());
  }
  */
}
