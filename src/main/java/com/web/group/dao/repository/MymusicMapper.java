package com.web.group.dao.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.group.entity.Mymusic;
import org.springframework.stereotype.Repository;

@Repository
public interface MymusicMapper extends BaseMapper<Mymusic> {

    int deleteByPrimaryKey(Integer myId);

    @Override
    int insert(Mymusic record);

    int insertSelective(Mymusic record);

    Mymusic selectByPrimaryKey(Integer myId);

    int updateByPrimaryKeySelective(Mymusic record);

    int updateByPrimaryKey(Mymusic record);
}