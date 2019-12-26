package kr.co.sunnyside.popup.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sunnyside.cmn.DTO;
import kr.co.sunnyside.popup.service.PopupSvc;

@Service
public class PopupSvcImpl implements PopupSvc {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PopupDaoImpl popupDaoImpl;

	@Override
	public List<?> do_retrieve() {
		return popupDaoImpl.do_retrieve();
	}
	
}
