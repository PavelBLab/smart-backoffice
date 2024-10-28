package com.quarkus.smartbackoffice.persistence.repository;


import com.quarkus.smartbackoffice.persistence.entity.Article;
import com.quarkus.smartbackoffice.persistence.entity.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase; // blocking (synchronized)
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ArticleSynchronizedRepository implements PanacheRepositoryBase<Article, Long> {

    public List<Article> listByCategory(Category category) {
        return find("category", Sort.by("price"), Sort.Direction.Descending, category)
                .page(Page.ofSize(3))
                .list();
    }

}
