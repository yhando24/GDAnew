package main.java.com.GDA.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

	public static final String ROLE_MANAGER = "MANAGER";
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";
	public static final String ROLE_ADMIN = "ADMIN";
	
	private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();
	
	static {
		init();
	}
	
	private static void init() {
		
		//employee
		List<String> urlPatterns1 = new ArrayList<String>();
		
		urlPatterns1.add("/abscencesManagementEmployee");
		urlPatterns1.add("/planningEmployee");
		urlPatterns1.add("/dayoffEmployee");
		urlPatterns1.add("/homeEmployee");
		
		mapConfig.put(ROLE_EMPLOYEE, urlPatterns1);
		
		//manager
		List<String> urlPatterns2 = new ArrayList<String>();
		
		urlPatterns2.add("/abscencesManagementManager");
		urlPatterns2.add("/planningManager");
		urlPatterns2.add("/dayoffManager");
		urlPatterns2.add("/homeManager");
		urlPatterns2.add("/approval");
		urlPatterns2.add("/report");
		
		mapConfig.put(ROLE_EMPLOYEE, urlPatterns2);
		
		//admin
		List<String> urlPatterns3 = new ArrayList<String>();
		
		urlPatterns3.add("/abscencesManagementAdmin");
		urlPatterns3.add("/planningAdmin");
		urlPatterns3.add("/dayoffAdmin");
		urlPatterns3.add("/homeAdmin");
		
		mapConfig.put(ROLE_EMPLOYEE, urlPatterns3);
	
		
	}
	
	public static Set<String> getAllAppRoles(){
		return mapConfig.keySet();
	}
	
	public static List<String> getUrlPatternsForRole(String role){
		return mapConfig.get(role);
	}
	
}
