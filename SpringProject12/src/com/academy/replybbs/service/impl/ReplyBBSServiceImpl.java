package com.academy.replybbs.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.academy.replybbs.service.ReplyBBSDto;
import com.academy.replybbs.service.ReplyBBSService;
/*
 * 이름 미 지정시 ID값은 소문자로 시작하는 클래스명이됨
 * 예]ReplyBBSServiceImpl클래인 경우 
 * ID값은 replyBBSServiceImpl
 * 지정도 가능 @Service("임의의ID값")
 */
@Service("bbsService")
public class ReplyBBSServiceImpl implements ReplyBBSService {
	//DAO계열 클래스 주입받기]
	@Resource(name="replyBBSDao")
	private ReplyBBSDao dao;
	
	@Override
	public boolean login(Map map) throws Exception {
		
		return dao.login(map);
	}

	@Override
	public List<ReplyBBSDto> selectList(Map map) throws Exception {
		
		return dao.selectList(map);
	}

	@Override
	public ReplyBBSDto selectOne(Map map) throws Exception {
		
		return dao.selectOne(map);
	}

	@Override
	public int insert(ReplyBBSDto dto) throws Exception {
		
		return dao.insert(dto);
	}

	@Override
	public int update(ReplyBBSDto dto) throws Exception {
		
		return dao.update(dto);
	}

	@Override
	public int delete(ReplyBBSDto dto) throws Exception {
		
		return dao.delete(dto);
	}

	@Override
	public int getTotalCount(Map map) throws Exception {
		
		return dao.getTotalCount(map);
	}

	@Override
	public void reply(Map map) throws Exception {
		dao.reply(map);		
	}

	@Override
	public void close() throws Exception {
		dao.close();		
	}

}
