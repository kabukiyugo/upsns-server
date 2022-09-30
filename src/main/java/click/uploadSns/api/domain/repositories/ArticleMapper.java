package click.uploadSns.api.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import click.uploadSns.api.domain.models.Article;
import click.uploadSns.api.domain.models.Dtos.ArticleDto;

@Mapper
public interface ArticleMapper {

        List<ArticleDto> findAll();

        List<ArticleDto> getTheLatest();

        Optional<ArticleDto> findById(int id);

        List<ArticleDto> findByUserId(int userId);

        List<ArticleDto> searchByTitle(String title);

        List<ArticleDto> searchByTagName(String tagName);

        public void insert(Article article);

        public void update(Article article);

        public void delete(int id);

        public void addImage(@Param("articleId") int articleId, @Param("imageId") int imageId);

        public void addTag(@Param("articleId") int articleId, @Param("tagId") int tagId);

        public void deleteImage(int id);

        public void deleteTag(int id);

}
