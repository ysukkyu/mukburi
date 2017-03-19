package mukburi.bbs.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import mukburi.common.dao.AbstractDAO;

@Repository("bbsDAO")
public class BbsDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		
		return (List<Map<String, Object>>)selectList("bbs.selectBoardList",map);
	}
	
	public void insertBoard(Map<String, Object> map) throws Exception{
	    insert("bbs.insertBoard", map);
	}


}
