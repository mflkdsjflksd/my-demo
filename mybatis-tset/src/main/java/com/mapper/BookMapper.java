package com.mapper;

import com.entity.BookTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    List<BookTest> selectBookById(@Param("id") int id);
}
