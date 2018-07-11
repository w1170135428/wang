package controller;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import dao.BusDAO;
import dao.BusDAOImp;
import domain.Bus;

public class BusAction extends ActionSupport {
	private List<String[]> buss;
	private List<Bus> bussByObj;
	Bus bus;
	

	public List<String[]> getBuss() {
		return buss;
	}

	public void setBuss(List<String[]> buss) {
		this.buss = buss;
	}

	public List<Bus> getBussByObj() {
		return bussByObj;
	}

	public void setBussByObj(List<Bus> bussByObj) {
		this.bussByObj = bussByObj;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String execute() throws Exception {
		BusDAO dao = new BusDAOImp();
		bussByObj = dao.getAllBusByObj();
		return SUCCESS;
	}

	public void getAllBusByObj() throws Exception {
		BusDAO dao = new BusDAOImp();
		bussByObj = dao.getAllBusByObj();
	}

	public String save() throws Exception {
		BusDAO dao = new BusDAOImp();
		boolean isBus = dao.save(bus);
		return isBus ? SUCCESS : ERROR;
	}

	public String edit() throws Exception {
		BusDAO dao = new BusDAOImp();
		System.out.println("µ±Ç°Ö´ÐÐ:"+bus.getId());
		bus = dao.findById(bus.getId());
		return SUCCESS;
	}

	public String update() throws Exception {
		BusDAO dao = new BusDAOImp();
		System.out.println(bus.getId());
		boolean isBus = dao.update(bus);
		return isBus ? SUCCESS : ERROR;
	}

	public String del() throws Exception {
		BusDAO dao = new BusDAOImp();
		boolean isBus = dao.delById(bus.getId());
		return isBus ? SUCCESS : ERROR;
	}
	public String findByPassenger() throws Exception{
		BusDAO dao = new BusDAOImp();
		bus = dao.findByPassenger(bus.getSt_city(),bus.getAr_city(),bus.getSt_time());
		return SUCCESS;
	}
}
