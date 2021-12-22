package com.consulting.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.consulting.dao.AcessLogDBdao;
import com.consulting.vo.AcessLog;

public class AcessLogAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(AcessLogAction.class);

	private List loglist;

	AcessLog acessLog;

	public List getLoglist() {
		return loglist;
	}

	public void setLoglist(List loglist) {
		this.loglist = loglist;
	}

	public String add() {

		return null;
	}

	public String delete() {

		return null;
	}

	public String edit() {

		return null;
	}

	public String execute() {
		log.info("Access Log");
		AcessLogDBdao acessLogDBdao = new AcessLogDBdao();
		acessLog=acessLogDBdao.getCurrentUsers(acessLog);
		loglist = acessLogDBdao.getAllList(acessLog);

		if (loglist == null || loglist.size() == 0) {
			addActionMessage("No Record Found(s)");
		}

		return SUCCESS;
	}

	public String save() {

		return null;
	}

	public String search() {

		return null;
	}

	public String update() {

		return null;
	}

	public void setRequest(Map arg0) {

	}

	public AcessLog getAcessLog() {
		return acessLog;
	}

	public void setAcessLog(AcessLog acessLog) {
		this.acessLog = acessLog;
	}

}
