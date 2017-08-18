package com.academy.replybbs.service;

import java.util.List;
import java.util.Map;

public interface ReplyBBSService {
	//로그인 처리]
	boolean login(Map map) throws Exception;
	//답변형 게시판 관련 CRUD작업용]
	//목록
	List<ReplyBBSDto> selectList(Map map) throws Exception;
	//상세보기
	ReplyBBSDto selectOne(Map map) throws Exception;
	//입력/수정/삭제]
	int insert(ReplyBBSDto dto) throws Exception;
	int update(ReplyBBSDto dto) throws Exception;
	int delete(ReplyBBSDto dto) throws Exception;
	//전체 레코드 수]
	int getTotalCount(Map map) throws Exception;
	//답변]
	void reply(Map map) throws Exception;
	
	//자원반납및 커넥션 풀 반납용]
	void close() throws Exception;
}
