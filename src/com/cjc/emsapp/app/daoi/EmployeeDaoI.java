package com.cjc.emsapp.app.daoi;
import java.util.List;

import com.cjc.emsapp.app.model.Employee;

public interface EmployeeDaoI {
	public void AddEmployeeData(Employee e);
	public List<Employee> viewEmployee();
	public void updatedata(Employee e1);
	
	public List<Employee> getDataByEid(int eid);
	public void deleteEmployee(int eid);
	public void createDBTable(String name);
	
	public void DropDBTable(String name);
	public void addTableColumn(String tname , String cname, String dtype,int len);
	public List<String> getDBtableName();
	
	public void getcolumnName(String tname);
	public void dropColumn(String tname , String cname);

}
