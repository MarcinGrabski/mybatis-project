package pl.grabski.mybatisproject.mapper;

import org.apache.ibatis.annotations.*;
import pl.grabski.mybatisproject.model.Cities;

import java.util.List;

@Mapper
public interface CityMapper {
    @Insert("INSERT INTO cities (name, state, country) VALUES (#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Cities city);

    @Select("SELECT id, name, state, country FROM cities WHERE id = #{id}")
    Cities findById(long id);

    @Select("SELECT id, name, state, country FROM cities")
    List<Cities> findALl();

    @Delete("DELETE FROM cities WHERE id = #{id}")
    void deleteId(long id);
}
