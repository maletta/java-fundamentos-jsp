package br.com.fundamentosjsp;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.fundamentosjsp.dao.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case a
	 * 
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {

		super(testName);
		System.out.println("ahh");
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet result = stm.executeQuery("select * from usuarios");
			while(result.next()) {
				System.out.println("resultado " + result.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(con);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigorous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}
}
