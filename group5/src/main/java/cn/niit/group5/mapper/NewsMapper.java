package cn.niit.group5.mapper;

import cn.niit.group5.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface NewsMapper {
//根据分类查询农资
    @Select("SELECT * FROM t_news WHERE  is_delete=0 and news_sort_id=#{0}")
    List<News> selectAllBySortId(Integer sortId);
//模糊查询资讯
    @Select(" SELECT * FROM t_news WHERE title LIKE concat('%',#{title},'%') " +
            "OR content LIKE concat('%',#{title},'%') order by create_time desc"
          )
    List<News> getNewsBySearch(String title);


}