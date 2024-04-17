package com.bankz.utilities;

public class UtilityTasks{
	public static void checkNull(Object obj) throws InvalidInputException{
	
		String reason="Improper Input!";
		checkNull(obj,reason);
}
public static void checkNull(Object obj,String reason) throws InvalidInputException{
	if (obj==null){
		throw new InvalidInputException(reason);
	}
}

}