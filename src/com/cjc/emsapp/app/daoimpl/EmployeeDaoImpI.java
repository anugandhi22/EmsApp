package com.cjc.emsapp.app.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cjc.emsapp.app.util.JDBCConnectivity;
import com.cjc.emsapp.app.daoi.EmployeeDaoI;
import com.cjc.emsapp.app.model.Employee;
import com.mysql.cj.protocol.Resultset;

public class EmployeeDaoImpI implements EmployeeDaoI {

	@Override
	public void AddEmployeeData(Employee e) {

		try {
			Connection con = JDBCConnectivity.getConnection();
	//Class.forName("com.mysql.cj.jdbc.Driver");
	//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emsapp", "root", "root");

			String sql = "insert into employee value(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e.getEid());
			ps.setString(2, e.getEname());
			ps.setDouble(3, e.getSalary());
			ps.setString(4, e.getEmailId());

			ps.execute();
			System.out.println("\nData Insert Succesfully..!\n");

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Employee> viewEmployee() {
		List<Employee> li = new ArrayList<Employee>();
		try {
			Connection con = JDBCConnectivity.getConnection();
	//Class.forName("com.mysql.cj.jdbc.Driver");
		//	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emsapp", "root", "root");

			String sql = "select * from employee";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
//			li.add(rs.getInt(1));
				Employee e = new Employee();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setEmailId(rs.getString(4));

				li.add(e);

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return li;
	}

	@Override
	public void updatedata(Employee e1) {

		try {
			Connection con = JDBCConnectivity.getConnection();
	//	Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emsapp", "root", "root");

			String sql = "update employee set name=?,salary=?,gmail=? where eid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e1.getEname());
			ps.setDouble(2, e1.getSalary());
			ps.setString(3, e1.getEmailId());
			ps.setInt(4, e1.getEid());

			ps.execute();
			System.out.println("\nData Update Succesfully..!\n");

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	@Override
	public List<Employee> getDataByEid(int eid) {

		List<Employee> li = new ArrayList<Employee>();
		try {
			Connection con = JDBCConnectivity.getConnection();
	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/emsapp", "root", "root");

			String sql = "select * from employee where eid=?";
			PreparedStatement ps = con1.prepareStatement(sql);
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
	li.add(rs.getInt(1), null);
				Employee e = new Employee();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setEmailId(rs.getString(4));

				li.add(e);

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return li;

	}

	public void deleteEmployee(int eid) {

		try {
			Connection con = JDBCConnectivity.getConnection();
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		//	Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/emsapp","root","root");

			String sql = "delete from employee where eid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, eid);
	ResultSet rs=ps.executeQuery();
			ps.execute();

		} catch (Exception exe) {
			exe.printStackTrace();
		}

	}

	public void createDBTable(String name) {
		try {

			Connection con = JDBCConnectivity.getConnection();

			String sql = "create table " + name + "(id int,name varchar(50))";
			Statement s = con.createStatement();
			s.execute(sql);
			System.out.println("\n Table Was Create'd..!\n");

		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void DropDBTable(String name) {

		try {

			Connection con = JDBCConnectivity.getConnection();

			String sql = "Drop table " + name + "";
			Statement s = con.createStatement();
			s.execute(sql);
			System.out.println("\n Table Was Delete'd..!\n");

		} catch (Exception x) {
			x.printStackTrace();
		}

	}

	public void addTableColumn(String tname, String cname, String dtype, int len) {

		try {
	System.out.println(tname + " " + cname + " " + dtype + " " + len + "\n");

			Connection con = JDBCConnectivity.getConnection();
			String sql = "ALTER TABLE " + tname + " ADD COLUMN " + cname + " " + dtype + "(" + len + ")";
			Statement dt = con.createStatement();
			dt.execute(sql);

			System.out.println("\n Column Was Create'd..!\n");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<String> getDBtableName() {

		List<String> li = new ArrayList<String>();
		try {

			Connection con = JDBCConnectivity.getConnection();
			String sql = "SHOW tables";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				li.add(rs.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	public void getcolumnName(String tname) {

		try {

			Connection con = JDBCConnectivity.getConnection();
			String sql = "SHOW COLUMNS FROM "+tname+"";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString("Field")+", ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void dropColumn(String tname , String cname) {
		
		try {
			
			Connection con=JDBCConnectivity.getConnection();
			String sql="ALTER TABLE "+tname+" DROP COLUMN "+cname+"";
			Statement st=con.createStatement();
			st.execute(sql);
			System.out.println("\nDroping column Sucessfully...!\n");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
