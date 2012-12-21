import java.util.ArrayList;
import java.util.List;

import util.GsonUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.User;


public class Main {

	public static void main(String[] args) {
		
		Gson a = new Gson();
		
		String json = GsonUtils.toJson(getUser());
		System.out.println(json);
		
		User c = GsonUtils.fromJson(json, User.class);
		
		System.out.println("Objeto" + c.toString());
		
		System.out.println(c);
		
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			users.add(getUser());
		}
		
		String b = GsonUtils.toJson(users);
		
		System.err.println( b );
		
	}
	
	
	
	public static User getUser() {
		User user = new User();
		user.setId(1L);
		user.setEmail("TESTE@");
		user.setName("TESTE");
		user.setPassword("Adfkomfkasmd");
		user.setCreatedDate("10/10/2010");
		user.setUpdateDate(null);
		
		
		
		return user;
	}
	
}
