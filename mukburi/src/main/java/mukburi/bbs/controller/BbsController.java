package mukburi.bbs.controller;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mukburi.bbs.service.BbsService;
import mukburi.common.common.CommandMap;
 
@Controller
public class BbsController {
    Logger log = Logger.getLogger(this.getClass());
     
    @Resource(name="bbsService")			//BbsServiceImpl의 Service 어노테이션 
    private BbsService bbsService;
     
    @RequestMapping(value="/bbs/openBoardList.do")
    public ModelAndView openBoardList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/bbs/boardList");
        
        List<Map<String,Object>> list = bbsService.selectBoardList(commandMap);
        mv.addObject("list", list);
          
        return mv;
    }
    
    @RequestMapping(value="/bbs/openBoardWrite.do")
    public ModelAndView openBoradWrite(Map<String,Object> commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/bbs/boardWrite");   	
    	return mv;
    }
    
    @RequestMapping(value="/bbs/insertBoard.do")
    public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/bbs/openBoardList.do");
         
        bbsService.insertBoard(commandMap.getMap());
         
        return mv;
    }
    
    @RequestMapping(value="/bbs/testMapArgumentResolver.do")
    public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView(""); 
          
        if(commandMap.isEmpty() == false){
            Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry<String,Object> entry = null;
            while(iterator.hasNext()){
                entry = iterator.next();
                log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
            }
        }   
        return mv;
    }

    
}

