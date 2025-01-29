package com.example.demo.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.example.demo.model.UserStatus;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql("/sql/user-repository-test-data.sql")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByIdAndStatus_로_유저_데이터를_찾아올_수_있다(){
        //given
        //when
        Optional<UserEntity> result = userRepository.findByIdAndStatus(1,UserStatus.ACTIVE);

        //then
        assertThat(result.isPresent()).isTrue();
    }

    @Test
    void findByIdAndStatus_는_데이터가_없으면_Optional_empty_를_내려준다(){
        //given
        //when
        Optional<UserEntity> result = userRepository.findByIdAndStatus(1,UserStatus.PENDING);

        //then
        assertThat(result.isEmpty()).isTrue();
    }
    @Test
    @DisplayName("findByEmailAndStatus()로 유저 데이터를 찾아올 수 있다")
    void findByEmailAndStatusSuccessTest(){
        //given
        //when
        Optional<UserEntity> result = userRepository.findByEmailAndStatus("ckwjdans4182@gmail.com",UserStatus.ACTIVE);

        //then
        assertThat(result.isPresent()).isTrue();
    }
    @Test
    @DisplayName("findByEmailAndStatus()는 데이터가 없으면 Optional empty 를 내려준다")
    void findByEmailAndStatusEmptyTest(){
        //given
        //when
        Optional<UserEntity> result = userRepository.findByEmailAndStatus("ckwjdans4182@gmail.com",UserStatus.PENDING);

        //then
        assertThat(result.isEmpty()).isTrue();
    }
}
