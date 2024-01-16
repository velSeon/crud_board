package com.curd.crud_board.repository.querydsl;

import com.curd.crud_board.domain.Article;
import com.curd.crud_board.domain.QArticle;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ArticleRepositoryCustomImpl extends QuerydslRepositorySupport implements ArticleRepositoryCustom {

    public ArticleRepositoryCustomImpl(){
        super(Article.class);
    }

    @Override
    public List<String> findAllDistinctHashtags(){
        QArticle article = QArticle.article;

        return from(article)
                .distinct()
                .select(article.hashtag)
                .where(article.hashtag.isNotNull())
                .fetch();
    }
}
