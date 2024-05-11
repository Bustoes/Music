package com.web.group.dao.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.group.entity.Musiclink;
import org.springframework.stereotype.Repository;

@Repository
public interface MusiclinkMapper extends BaseMapper<Musiclink> {

    int deleteByPrimaryKey(Integer mlId);

    @Override
    int insert(Musiclink record);

    int insertSelective(Musiclink record);

    Musiclink selectByPrimaryKey(Integer mlId);

    int updateByPrimaryKeySelective(Musiclink record);

    int updateByPrimaryKey(Musiclink record);
}