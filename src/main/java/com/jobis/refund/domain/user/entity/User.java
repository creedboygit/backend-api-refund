package com.jobis.refund.domain.user.entity;

import com.jobis.refund.domain.user.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_IDX")
    private Long idx;

    @Column(name = "USER_ID", nullable = false, length = 30, unique = true)
    private String userId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME", nullable = false, length = 30)
    private String name;

    @Column(name = "REG_NO", nullable = false, unique = true)
    private String regNo;
}