package app;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import dto.JoinDto;
import dto.LoginDto;

public class ReflectApp {

	// Object가 아닌 제네릭으로 모든 타입을 받을 수 있게 설정한다.
	static <T> void myReflect(T dto) {
		Method[] methods = dto.getClass().getMethods();

		// 크기 만큼 돌면서 배열에 담긴다
		for (Method method : methods) {
			//System.out.println("method.getName(): " + method.getName());
		}

		Field[] fs = dto.getClass().getDeclaredFields();

		for (Field f : fs) {
			f.setAccessible(true);
			try {
				if(f.getName().equals("password")) {
					f.set(dto, "5678");
				}
				Object o = f.get(dto);
				System.out.println(o);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		LoginDto loginDto = new LoginDto();
		loginDto.setUsername("ssar");
		loginDto.setPassword("1234");
		myReflect(loginDto);
		
		JoinDto joinDto = new JoinDto();
		joinDto.setUsername("ssar");
		joinDto.setPassword("1234");
		joinDto.setEmail("ssar@nate.com");
		myReflect(joinDto);

	}

}
