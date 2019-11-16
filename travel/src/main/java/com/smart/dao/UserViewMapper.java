package com.smart.dao;

import com.smart.domain.UserView;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserViewMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_view
     *
     * @mbg.generated Wed Oct 23 15:03:05 CST 2019
     */
    int insert(UserView record);

    int check(UserView record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_view
     *
     * @mbg.generated Wed Oct 23 15:03:05 CST 2019
     */
    List<UserView> selectAll();
}