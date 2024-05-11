package com.web.group.service.impl;

import com.web.group.dao.operator.MusiclinkOperator;
import com.web.group.entity.Musiclink;
import com.web.group.service.IMusiclinkService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusiclinkService implements IMusiclinkService {

    @Autowired
    private MusiclinkOperator musiclinkOperator;

    @Override
    public Musiclink getMusiclinkInfoById(Integer id) {
        return musiclinkOperator.getMusiclinkInfoById(id);
    }

    public List<Musiclink> getMusiclinkInfoBySongName(String songName) {
        return musiclinkOperator.getMusiclinkInfoBySongName(songName);
    }

    public List<Musiclink> getMusiclinkList() {
        List<Musiclink> list = musiclinkOperator.list();
        return CollectionUtils.isNotEmpty(list) ? list : null;
    }

}
