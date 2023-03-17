package com.jobis.refund.api.service.user.mapper;

import com.jobis.refund.api.controller.user.request.AddUserRequest;
import com.jobis.refund.domain.user.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-16T16:29:20+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4 (GraalVM Community)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(AddUserRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.userId( request.getUserId() );
        user.password( request.getPassword() );
        user.name( request.getName() );
        user.regNo( request.getRegNo() );

        return user.build();
    }
}
