package com.curd.crud_board.repository;

import com.curd.crud_board.domain.Article;
import com.curd.crud_board.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>,
        QuerydslBinderCustomizer<QArticle> {
    //    QuerydslPredicateExecutor 엔티티에 있는 모든 필드에 대한 기본 검색 기능을 추가해줌
    Page<Article> findByTitle(String title, Pageable pageable);

    @Override
    default void customize(QuerydslBindings bindings, QArticle root) {
        //QuerydslPredicateExecutor로 모든 필터가 열려있어 선택적 검색을 가능하게 하기 위해
        //리스팅을 하지 않은 프로퍼티는 검색에서 제외시키는 것
        bindings.excludeUnlistedProperties(true);
        //원하는 필드 추가
        bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.createdBy);
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);

//        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);//대소문자 구분 안함 //like '%${v}%'
//        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);//대소문자 구분 안함 //like '%${v}%'
////        bindings.bind(root.title).first(StringExpression::likeIgnoreCase); // like '${v}'
//        bindings.bind(root.createdAt).first(DateTimeExpression::eq); // like '${v}'
//        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase); // like '${v}'
    }

}
