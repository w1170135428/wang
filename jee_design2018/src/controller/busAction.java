package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.BusDAO;
import dao.BusDAOImp;
import domain.Bus;

public class BusAction extends ActionSupport {
	List<String[]> buss;
  private List<Bus> bussByObj;

	public List<String[]> getbuss() {
		return buss;
	}

	public List<Bus> getbusByObj() {
    return bussByObj;
  }
	Bus bus;

  public Bus getbus() {
    return bus;
  }

  public void setbus(Bus bus) {
    this.bus = bus;
  }

  public String execute() throws Exception {
		BusDAO dao = new BusDAOImp();
		buss = dao.getAllbuss();
		getAllbussByObj();
		return SUCCESS;
	}
	public void getAllbussByObj()throws Exception {
	  BusDAO dao=new BusDAOImp();
	  bussByObj=dao.getAllbussByObj();	  
	}
	public String save() throws Exception{
	  BusDAO dao=new BusDAOImp();
	  boolean isSuc=dao.save(bus);
	  return isSuc?SUCCESS:ERROR;
	}
	public String edit() throws Exception{
    BusDAO dao=new BusDAOImp();
    bus=dao.findById(bus.getId());
    return SUCCESS;
  }
	public String update() throws Exception{
    BusDAO dao=new BusDAOImp();
    boolean isSuc=dao.update(bus);
    return isSuc?SUCCESS:ERROR;
  }
	public String del() throws Exception{
    BusDAO dao=new BusDAOImp();
    boolean isSuc=dao.delById(bus.getId());
    return isSuc?SUCCESS:ERROR;
  }
}
