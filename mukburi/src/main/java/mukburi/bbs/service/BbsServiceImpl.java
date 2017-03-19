package mukburi.bbs.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mukburi.bbs.dao.BbsDAO;

@Service("bbsService")
public class BbsServiceImpl implements BbsService {

	@Resource(name="bbsDAO")
	private BbsDAO bbsDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		
		return bbsDAO.selectBoardList(map);
	}
	
	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
	    bbsDAO.insertBoard(map);
	}

}
