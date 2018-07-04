package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.busDAO;
import dao.busDAOImp;
import domain.bus;

public class busAction extends ActionSupport {
	List<String[]> stus;
  private List<bus> stusByObj;

	public List<String[]> getStus() {
		return stus;
	}

	public List<bus> getStusByObj() {
    return stusByObj;
  }
	bus stu;

  public bus getStu() {
    return stu;
  }

  public void setStu(bus stu) {
    this.stu = stu;
  }

  public String execute() throws Exception {
		busDAO dao = new busDAOImp();
		stus = dao.getAllStus();
		getAllStusByObj();
		return SUCCESS;
	}
	public void getAllStusByObj()throws Exception {
	  busDAO dao=new busDAOImp();
	  stusByObj=dao.getAllStusByObj();	  
	}
	public String save() throws Exception{
	  busDAO dao=new busDAOImp();
	  boolean isSuc=dao.save(stu);
	  return isSuc?SUCCESS:ERROR;
	}
	public String edit() throws Exception{
    busDAO dao=new busDAOImp();
    stu=dao.findById(stu.getId());
    return SUCCESS;
  }
	public String update() throws Exception{
    busDAO dao=new busDAOImp();
    boolean isSuc=dao.update(stu);
    return isSuc?SUCCESS:ERROR;
  }
	public String del() throws Exception{
    busDAO dao=new busDAOImp();
    boolean isSuc=dao.delById(stu.getId());
    return isSuc?SUCCESS:ERROR;
  }
}
