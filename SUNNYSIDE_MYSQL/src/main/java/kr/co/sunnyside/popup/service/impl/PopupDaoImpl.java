package kr.co.sunnyside.popup.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sunnyside.cmn.DTO;
import kr.co.sunnyside.popup.service.PopupVO;

@Repository
public class PopupDaoImpl {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE = "popup";
	
	public int do_save(DTO dto) {
		String statement = this.NAMESPACE + ".do_save";
		
		LOG.debug("==================================");
		LOG.debug("statement = " + statement);
		LOG.debug("==================================");
		
		PopupVO popupVO = (PopupVO) dto;
		
		LOG.debug("==================================");
		LOG.debug("popupVO = " + popupVO);
		LOG.debug("==================================");
		
		int flag = sqlSessionTemplate.insert(statement, popupVO);
		
		LOG.debug("==================================");
		LOG.debug("flag = " + flag);
		LOG.debug("==================================");
		
		return flag;
	}


	public List<?> do_retrieve() {
		String statement = this.NAMESPACE + ".do_retrieve";
	
		LOG.debug("==================================");
		LOG.debug("statement = " + statement);
		LOG.debug("==================================");

		List<PopupVO> list = sqlSessionTemplate.selectList(statement);
		
		LOG.debug("==================================");
		LOG.debug("list = " + list);
		LOG.debug("==================================");
		
		return list;
	}
	
}
