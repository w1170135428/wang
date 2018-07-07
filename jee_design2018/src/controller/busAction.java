package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.BusDAO;
import dao.BusDAOImp;
import domain.Bus;

public class BusAction extends ActionSupport {
	private List<String[]> bus;
	private List<Bus> BusByObj;
	

	public List<String[]> getBus() {
		return bus;
	}
	public void setBus(List<String[]> bus) {
		this.bus = bus;
	}
	public List<Bus> getBusByObj() {
		return BusByObj;
	}
	public void setBusByObj(List<Bus> busByObj) {
		BusByObj = busByObj;
	}
public String execute() throws Exception {
		BusDAO dao = new BusDAOImp();
		bus = dao.getAllBus();
		getAllBusByObj();
		return SUCCESS;
	}
	public void getAllBusByObj()throws Exception {
	  BusDAO dao=new BusDAOImp();
	  BusByObj=dao.getAllBusByObj();	  
	}
	public String save() throws Exception{
	  BusDAO dao=new BusDAOImp();
	  boolean isBus=dao.save((Bus) bus);
	  return isBus?SUCCESS:ERROR;
	}
	public String edit() throws Exception{
    BusDAO dao=new BusDAOImp();
   // for(Object object:bus);
    bus=dao.findById((bus).getId());
    return SUCCESS;
  }
	public String update() throws Exception{
    BusDAO dao=new BusDAOImp();
    boolean isBus=dao.update(bus);
    return isBus?SUCCESS:ERROR;
  }
	public String del() throws Exception{
    BusDAO dao=new BusDAOImp();
    boolean isBus=dao.delById(bus.getId());
    return isBus?SUCCESS:ERROR;
  }
}
