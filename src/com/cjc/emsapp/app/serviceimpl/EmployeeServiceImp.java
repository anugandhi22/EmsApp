package com.cjc.emsapp.app.serviceimpl;

import com.cjc.emsapp.app.servicei.EmployeeServiceI;
import java.util.List;

import com.cjc.emsapp.app.daoi.EmployeeDaoI;
import com.cjc.emsapp.app.daoimpl.EmployeeDaoImpI;
import com.cjc.emsapp.app.model.Employee;


public class EmployeeServiceImp implements EmployeeServiceI {

	EmployeeDaoI emi = new EmployeeDaoImpI();

	@Override
	public void AddEmployeeData(Employee e) {
		emi.AddEmployeeData(e);
	}

	@Override
	public List<Employee> viewEmployee() {
		List<Employee> list = emi.viewEmployee();
		return list;
	}

	@Override
	public void updatedata(Employee e1) {
		emi.updatedata(e1);
	}

	@Override
	public List<Employee> getDataByEid(int eid) {
		List<Employee> list = emi.getDataByEid(eid);
		return list;
	}
	
	public void deleteEmployee(int eid) {
		emi.deleteEmployee(eid);
	}
	public void createDBTable(String name) {
		emi.createDBTable(name);
	}

	@Override
	public void DropDBTable(String name) {

		emi.DropDBTable(name);
	}

	@Override
	public void addTableColumn(String tname , String cname, String dtype,int len) {

		emi.addTableColumn(tname,cname,dtype,len);
	}

	@Override
	public List<String> getDBtableName() {

		List<String> names=emi.getDBtableName();
		return names;
	}
	public void getcolumnName(String tname) {
		emi.getcolumnName(tname);
	}
	
	public void dropColumn(String tname , String cname) {
		emi.dropColumn(tname, cname);
	}

}

