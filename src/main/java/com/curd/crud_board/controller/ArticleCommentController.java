package com.curd.crud_board.controller;

import com.curd.crud_board.dto.UserAccountDto;
import com.curd.crud_board.dto.request.ArticleCommentRequest;
import com.curd.crud_board.service.ArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Repository("/comments")
@Controller
public class ArticleCommentController {
    private final ArticleCommentService articleCommentService;

    @PostMapping("/new")
    public String postNewArticleComment(ArticleCommentRequest articleCommentRequest){
        //TODO: 인증정보 넣어줘야함
        articleCommentService.saveArticleComment(articleCommentRequest.toDto(UserAccountDto.of(
                "uno", "asdf1234", "uno@mail.com",null,null)));
        return "redirect:/articles/" + articleCommentRequest.articleId();
    }

    @PostMapping("/{commentId}/delete")
    public String deleteArticleCommnet(@PathVariable Long commentId,Long articleId){
        articleCommentService.deleteArticleComment(commentId);
        return "redirect:/articles/"+articleId;
    }
}
