package com.web.group.service.impl;

import com.web.group.dao.operator.MymusicOperator;
import com.web.group.entity.Musiclink;
import com.web.group.entity.Mymusic;
import com.web.group.service.IMymusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MymusicService implements IMymusicService {

    @Autowired
    private MymusicOperator mymusicOperator;

    @Override
    public Mymusic getMymusicInfoById(Integer id) {
        return mymusicOperator.getMymusicInfoById(id);
    }

    public List<Mymusic> getMymusicInfoBySongNameAndUserId(String songName, Integer userId) {
        return mymusicOperator.getMymusicInfoBySongNameAndUserId(songName, userId);
    }

    public List<Mymusic> getMymusicInfoByUserId(Integer userId) {
        return mymusicOperator.getMymusicInfoByUserId(userId);
    }

    public boolean insertMusicInfo(Musiclink musiclink , Integer userId) {
        Mymusic mymusic = new Mymusic();
        mymusic.setMySongname(musiclink.getMlSongname());
        mymusic.setMySinger(musiclink.getMlSinger());
        mymusic.setMySonglink(musiclink.getMlSonglink());
        mymusic.setMyLyriclink(musiclink.getMlLyriclink());
        mymusic.setMyPhotolink(musiclink.getMlPhotolink());
        mymusic.setUserId(userId);
        return mymusicOperator.insertMusicInfo(mymusic);
    }

    public boolean deleteMyMusic(Integer myId, Integer userId) {
        return mymusicOperator.deleteMyMusic(myId, userId);
    }



}
