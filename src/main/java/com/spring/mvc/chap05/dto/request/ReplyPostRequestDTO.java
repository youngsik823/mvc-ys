package com.spring.mvc.chap05.dto.request;

import com.spring.mvc.chap05.entity.Reply;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
@Builder
// RequestDTO는 클라이언트가 제대로 값을 보냈는지 검증해야함
public class ReplyPostRequestDTO {
    // 필드명은 클라이언트 개발자와 상의해야 함
    @NotBlank // 필수값
    private String text; // 댓글 내용

    @NotBlank
    @Size(min = 2, max = 8)
    private String author; // 댓글 작성자명

    /*
        @NotNull  -  null을 허용하지 않음
        @NotBlank -  null + ""을 허용하지 않음
     */
    @NotNull
    private Long bno; // 원본 글 번호

    // dto를 entity로 바꿔서 리턴하는 메서드
    public Reply toEntity() {
        return Reply.builder()
                .replyText(this.text)
                .replyWriter(this.author)
                .boardNo(this.bno)
                .build();
    }

}
