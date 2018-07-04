package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.busDAO;
import dao.busDAOImp;
import domain.bus;

public class busAction extends ActionSupport {
	List<String[]> buss;
  private List<bus> bussByObj;

	public List<String[]> getbuss() {
		return buss;
	}

	public List<bus> getbusByObj() {
    return bussByObj;
  }
	bus bus;

  public bus getbus() {
    return bus;
  }

  public void setbus(bus bus) {
    this.bus = bus;
  }

  public String execute() throws Exception {
		busDAO dao = new busDAOImp();
		buss = dao.getAllbuss();
		getAllbussByObj();
		return SUCCESS;
	}
	public void getAllbussByObj()throws Exception {
	  busDAO dao=new busDAOImp();
	  bussByObj=dao.getAllbussByObj();	  
	}
	public String save() throws Exception{
	  busDAO dao=new busDAOImp();
	  boolean isSuc=dao.save(bus);
	  return isSuc?SUCCESS:ERROR;
	}
	public String edit() throws Exception{
    busDAO dao=new busDAOImp();
    bus=dao.findById(bus.getId());
    return SUCCESS;
  }
	public String update() throws Exception{
    busDAO dao=new busDAOImp();
    boolean isSuc=dao.update(bus);
    return isSuc?SUCCESS:ERROR;
  }
	public String del() throws Exception{
    busDAO dao=new busDAOImp();
    boolean isSuc=dao.delById(bus.getId());
    return isSuc?SUCCESS:ERROR;
  }
}
