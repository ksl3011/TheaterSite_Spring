package kr.co.sunnyside.popup.service;

import kr.co.sunnyside.cmn.DTO;

public class PopupVO extends DTO {
	private String title;
	private String contents;
	private String enable;
	
	public PopupVO() {}

	public PopupVO(String title, String contents, String enable) {
		super();
		this.title = title;
		this.contents = contents;
		this.enable = enable;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "PopupVO [title=" + title + ", contents=" + contents + ", enable=" + enable + ", toString()="
				+ super.toString() + "]";
	}

}
