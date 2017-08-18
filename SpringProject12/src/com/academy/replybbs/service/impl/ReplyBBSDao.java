package com.academy.replybbs.service.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.academy.replybbs.service.ReplyBBSDto;
import com.academy.replybbs.service.ReplyBBSService;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.sqlmap.engine.impl.SqlMapSessionImpl;

@Repository
public class ReplyBBSDao implements ReplyBBSService{
	/*
	 * --------------------------------------------
	 * myBatis프레임워크 사용(mybatis-3.버전.jar)
	 * -SqlSessionFactory타입 객체 사용  
	   -형변환 불필요(iBatis는 형변환 해야 함)  
	 * --------------------------------------------
	 */
	/* [스프링에서 지원하는  
	     마이바티스 관련 API(mybatis-spring-1.버전.jar) 미 사용]	  
	   [프로그래밍 순서]
	     	가. SqlSessionFactory타입의 openSession()메소드로 SqlSession타입 얻기 
	     	나. SqlSession타입의 메소드 호출
	        	.쿼리문이	SELECT 
	  	                  	다중레코드 일때:selectList()
	  	                  	단일 레코드일때:selectOne()
	        	.쿼리문이 	INSERT - insert()
	                 		DELETE - delete()
	                 		UPDATE - update()메소드
	             		      단,I/D/U일때는 반드시 commit()호출
	             
	  		다.-close()호출                    
	*/
	/*
	private static SqlSessionFactory sqlMapper;
	static {
	    try {
	      Reader reader = Resources.getResourceAsReader("mybatis/Configuration.xml");
	      sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	      reader.close(); 
	    } catch (IOException e) {e.printStackTrace();}
	}
	*/
	/*[스프링에서 지원하는  
    마이바티스 관련 API(mybatis-spring-1.버전.jar) 사용]
    -위 프로그래밍 순서의 (가)  및 (나)에서는 commit()호출
      그리고 (다)의 close()호출 불필요 
    */
	@Resource(name="template")
	private SqlSessionTemplate template;
	
	@Override
	public boolean login(Map map) throws Exception {
		/* 스프링지원 마이바티스 API 미 사용시*/
		/*
		//1]SqlSession얻기
		SqlSession session=sqlMapper.openSession();
		//2]selectOne()호출
		int count=session.selectOne("ReplyBBSLogin",map);
		//3]close()호출
		session.close();
		*/
		/* 스프링지원 마이바티스 API 사용시*/
		int count = template.selectOne("ReplyBBSLogin",map);
		return count ==1 ? true : false;
	}/////////////////////////////////////////////////

	@Override
	public List<ReplyBBSDto> selectList(Map map) throws Exception {
		
		return template.selectList("ReplyBBSlist",map);
	}

	@Override
	public ReplyBBSDto selectOne(Map map) throws Exception {
		
		return template.selectOne("ReplyBBSone",map);
	}

	@Override
	public int insert(ReplyBBSDto dto) throws Exception {
		/* 스프링지원 마이바티스 API 미 사용시*/
		/*
		//1]SqlSession얻기
		SqlSession session=sqlMapper.openSession();
		//2]insert()호출
		int count=session.insert("ReplyBBSinsert",dto);
		//3]commit() 호출
		session.commit();
		//3]close()호출
		session.close();
		*/
		int count = template.insert("ReplyBBSinsert",dto);
		return count;
	}

	@Override
	public int update(ReplyBBSDto dto) throws Exception {
		
		return template.update("ReplyBBSupdate",dto);
	}

	@Override
	public int delete(ReplyBBSDto dto) throws Exception {
		
		return template.delete("ReplyBBSdelete",dto);
	}

	@Override
	public int getTotalCount(Map map) throws Exception {
		
		return template.selectOne("ReplyBBStotal",map);
	}

	@Override
	public void reply(Map map) throws Exception {
		template.update("ReplyBBSreply_update",map);
		template.insert("ReplyBBSreply_insert",map);
	}

	@Override
	public void close() throws Exception {}

	/*
	 * --------------------------------------------
	 * iBatis프레임워크 사용
	 * -SqlMapClient타입 객체 사용  
	 * --------------------------------------------
	 */
	/*
	1.JDBC API 불필요(Connection/PreparedStatement/ResultSet객체 선언 불필요)
	2.자원반납 불필요(프레임워크가 스스로 자원반납)
	3.SqlMapClient타입 객체 사용
	   3-1.쿼리문이 SELECT 
	  	   - 쿼리결과가 다중레코드 일때:queryForList()
	  	   -           단일 레코드일때:queryForObject()
	   3-2.쿼리문이 INSERT/DELETE/UPDATE일때
	       -update()메소드
	
	*/
	/* 스프링이 iBatis관련해서 지원하는 API 미사용시*/ 
	/*
	private static SqlMapClient sqlMapper;
	static {
	    try {
	      Reader reader = Resources.getResourceAsReader("ibatis/SqlMapConfig.xml");
	      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
	      reader.close(); 
	    } catch (IOException e) {e.printStackTrace();}
	}
	*/
	/*스프링에서 제공하는 API사용으로 SqlMapClient주입하기
	 -단 try~catch는 해야됨. */
	/*
	@Resource(name="sqlMapClient")
	private SqlMapClient sqlMapper;
	*/
	/* SqlMapClientTemplate 주입-try~catch불필요 */
	/*
	@Resource(name="ibatisTemplate")
	private SqlMapClientTemplate sqlMapper;
	
	@Override
	public boolean login(Map map) throws Exception {
		
		return (Integer)sqlMapper.queryForObject("ReplyBBS.Login",map)==1 ? true :false;
	}

	@Override
	public List<ReplyBBSDto> selectList(Map map) throws Exception {
		return sqlMapper.queryForList("ReplyBBS.list",map);
		
	}

	@Override
	public ReplyBBSDto selectOne(Map map) throws Exception {
		
		return (ReplyBBSDto)sqlMapper.queryForObject("ReplyBBS.one",map);
	}

	@Override
	public int insert(ReplyBBSDto dto) throws Exception {
		return sqlMapper.update("ReplyBBS.insert", dto);		
	}

	@Override
	public int update(ReplyBBSDto dto) throws Exception {		
		return sqlMapper.update("ReplyBBS.update",dto);
	}

	@Override
	public int delete(ReplyBBSDto dto) throws Exception {
		
		return sqlMapper.update("ReplyBBS.delete",dto);
	}

	@Override
	public int getTotalCount(Map map) throws Exception {		
		return (Integer)sqlMapper.queryForObject("ReplyBBS.total",map);
	}

	@Override
	public void reply(Map map) throws Exception {
		sqlMapper.update("ReplyBBS.reply_update",map);
		sqlMapper.update("ReplyBBS.reply_insert",map);
	}
	@Override
	public void close() throws Exception {}
	*/
	
	/*
	 * --------------------------------------------
	 * JAVA JDBC API사용
	 * --------------------------------------------
	 */
	/*
	※@Resource어노테이션을 통해 주입받는 과정보다 생성자가 먼저다.
	Connection객체를 생성자안에서 초기화시
	NullPointerException발생
	예]conn=dataSource.getConnection()
	  dataSource는 null이다
	 */
	/*
	//DataSource주입]
	@Resource(name="datasourceByJNDI")
	private DataSource source;
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public boolean login(Map map) throws Exception {
		String sql="SELECT COUNT(*) FROM MEMBER WHERE ID=? AND PWD=?";
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, map.get("id").toString());
		psmt.setString(2, map.get("pwd").toString());
		rs = psmt.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		close();
		if(count==0) return false;
		return true;
	}///////////////////////////////

	@Override
	public List<ReplyBBSDto> selectList(Map map) throws Exception {
		List<ReplyBBSDto> list = new Vector<ReplyBBSDto>();
		String sql="SELECT * FROM (SELECT T.*,ROWNUM R FROM (SELECT RE.*,NAME FROM MEMBER M JOIN REPLYBBS RE ON M.ID=RE.ID ";
		//검색 쿼리 추가]
		if(map.get("searchColumn") != null){
			sql+=" WHERE "+map.get("searchColumn")+" LIKE '%"+map.get("searchWord")+"%' ";
		}
		sql+=" ORDER BY REFER DESC,STEP ASC) T) WHERE R BETWEEN ? AND ?";
		
		psmt = source.getConnection().prepareStatement(sql);
		
		psmt.setInt(1,Integer.parseInt(map.get("start").toString()));
		psmt.setInt(2,Integer.parseInt(map.get("end").toString()));
		
		
		rs = psmt.executeQuery();
		while(rs.next()){
			ReplyBBSDto dto = new ReplyBBSDto();
			dto.setContent(rs.getString(4));
			dto.setDepth(rs.getString(8));
			dto.setId(rs.getString(2));
			dto.setName(rs.getString(9));
			dto.setNo(rs.getString(1));
			dto.setPostdate(rs.getDate(5));
			dto.setRefer(rs.getString(6));
			dto.setStep(rs.getString(7));
			dto.setTitle(rs.getString(3));
			list.add(dto);
		}/////////////		
		close();
		return list;
	}/////////////////////////////////////////

	@Override
	public ReplyBBSDto selectOne(Map map) throws Exception {
		ReplyBBSDto dto=null;
		String sql="SELECT RE.*,NAME FROM MEMBER M JOIN REPLYBBS RE ON M.ID=RE.ID WHERE NO=?";
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, map.get("no").toString());
		rs = psmt.executeQuery();
		if(rs.next()){
			dto = new ReplyBBSDto();
			dto.setContent(rs.getString(4));
			dto.setDepth(rs.getString(8));
			dto.setId(rs.getString(2));
			dto.setName(rs.getString(9));
			dto.setNo(rs.getString(1));
			dto.setPostdate(rs.getDate(5));
			dto.setRefer(rs.getString(6));
			dto.setStep(rs.getString(7));
			dto.setTitle(rs.getString(3));
		}
		close();
		return dto;
	}///////////////////////////////////////

	@Override
	public int insert(ReplyBBSDto dto) throws Exception {
		int affected =0;
		String sql="INSERT INTO REPLYBBS(NO,ID,TITLE,CONTENT,REFER) VALUES(SEQ_REPLYBBS.NEXTVAL,?,?,?,SEQ_REPLYBBS.CURRVAL)";
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, dto.getId());
		psmt.setString(2, dto.getTitle());
		psmt.setString(3, dto.getContent());
		affected = psmt.executeUpdate();
		close();
		return affected;
	}/////////////////////////////////////////

	@Override
	public int update(ReplyBBSDto dto) throws Exception {
		String sql="UPDATE REPLYBBS SET TITLE=?,CONTENT=? WHERE NO=?";
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, dto.getTitle());
		psmt.setString(2, dto.getContent());
		psmt.setString(3, dto.getNo());
		int count=psmt.executeUpdate();
		close();
		return count;
	}

	@Override
	public int delete(ReplyBBSDto dto) throws Exception {
		String sql="DELETE REPLYBBS WHERE NO=?";
		psmt = source.getConnection().prepareStatement(sql);		
		psmt.setString(1, dto.getNo());
		int count=psmt.executeUpdate();
		close();
		return count;
	}

	@Override
	public int getTotalCount(Map map) throws Exception {
		String sql ="SELECT COUNT(*) FROM REPLYBBS RE JOIN MEMBER M ON RE.ID=M.ID ";
		//검색 쿼리 추가]
		if(map.get("searchColumn") != null){
			sql+=" WHERE "+map.get("searchColumn")+" LIKE '%"+map.get("searchWord")+"%' ";
		}
		psmt = source.getConnection().prepareStatement(sql);
		rs= psmt.executeQuery();
		rs.next();
		int total = rs.getInt(1);
		close();
		return total;
	}

	@Override
	public void reply(Map map) throws Exception {
		
		
		//기존 답글들의 step값 얻데이트
		String sql="UPDATE REPLYBBS SET STEP=STEP+1 WHERE REFER=? AND STEP > ?";
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, map.get("refer").toString());
		psmt.setString(2, map.get("step").toString());
		psmt.executeUpdate();
		
		//답글 입력
		sql = "INSERT INTO REPLYBBS VALUES(SEQ_REPLYBBS.NEXTVAL,?,?,?,SYSDATE,?,?,?)";
		psmt = source.getConnection().prepareStatement(sql);
		psmt.setString(1, map.get("id").toString());
		psmt.setString(2, map.get("title").toString());
		psmt.setString(3, map.get("content").toString());
		psmt.setString(4, map.get("refer").toString());
		psmt.setInt(5, Integer.parseInt(map.get("step").toString())+1);
		psmt.setInt(6,Integer.parseInt(map.get("depth").toString())+1);
		psmt.executeUpdate();
		
		close();
		
	}////////////////////////////////////

	@Override
	public void close() throws Exception {
		if(rs != null) rs.close();
		if(psmt !=null) psmt.close();
		if(conn !=null) conn.close();
	}/////////////////close()
	*/
}
