package team.debatechat.domain.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
@Entity
public class Member {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Size(max = 10)
    @Column(nullable = false, unique = true)
    private String nickname;

    private String password;

    private String introduction;

    private String interests;   // | 로 구분

    private String provider;

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    public Member(String nickname, String password, String introduction, String provider) {
        this.nickname = nickname;
        this.password = password;
        this.introduction = introduction;
        this.provider = provider;
    }
}
