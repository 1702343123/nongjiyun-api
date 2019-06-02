package cn.niit.group5.mapper;

import cn.niit.group5.entity.News;
import cn.niit.group5.entity.TechnologySort;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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

    //    根据审核状态选择资讯
    @Select("select * from t_news where review_status=#{reviewStatus} limit #{currPage}," +
            "#{pageSize}")
    List<News> getNewsByReview(News news);

    //删除问答
    @Update("UPDATE t_reply SET is_delete=1 WHERE id=#{0}")
    int delReplyQuestion(Integer id);

    // 删除农资分类
    @Delete("DELETE FROM t_technology_sort WHERE id=#{0}")
    int delTechnoSort(Integer id);

    //    修改农资分类
    int updateTechnoSort(TechnologySort technologySort);

//
int deleteByPrimaryKey(Integer id);

    int insert(News record);

    News selectByPrimaryKey(Integer id);

    List<News> selectAll(Map<Object,Object> map);

    int updateByPrimaryKey(News record);

//    改变状态
    int updateStatus(Map<Object,Object>map);
}