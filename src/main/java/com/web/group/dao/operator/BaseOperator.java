package com.web.group.dao.operator;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public abstract class BaseOperator<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

}
