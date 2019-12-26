package kr.co.sunnyside.popup.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.co.sunnyside.popup.service.PopupVO;
import kr.co.sunnyside.popup.service.impl.PopupSvcImpl;

@Controller
public class PopupCtrl {
	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PopupSvcImpl popupSvcImpl;

	@RequestMapping(value="popup/do_retrieve.do", method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String do_retrieve() {
		LOG.debug("========================");
		LOG.debug("=@Controller=popup");
		LOG.debug("========================");

		List<PopupVO> list= (List<PopupVO>) popupSvcImpl.do_retrieve();

		//json으로 변환
		Gson gson = new Gson();
		String json = gson.toJson(list);	
		
		return json;
	}
	
}
