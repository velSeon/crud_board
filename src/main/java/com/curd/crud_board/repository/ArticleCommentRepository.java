package com.curd.crud_board.repository;

import com.curd.crud_board.domain.Article;
import com.curd.crud_board.domain.ArticleComment;
import com.curd.crud_board.domain.QArticle;
import com.curd.crud_board.domain.QArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment>,
        QuerydslBinderCustomizer<QArticleComment>
{


    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root){
        //QuerydslPredicateExecutor로 모든 필터가 열려있어 선택적 검색을 가능하게 하기 위해
        //리스팅을 하지 않은 프로퍼티는 검색에서 제외시키는 것
        bindings.excludeUnlistedProperties(true);
        //원하는 필드 추가
        bindings.including(root.content, root.createdAt, root.createdBy);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq); // like '${v}'
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase); // like '${v}'
    }

}
