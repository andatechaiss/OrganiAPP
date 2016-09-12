package andatech.organizapp.server.utils;

import java.lang.reflect.Field;

public class ReflectionUtils 
{
	public static boolean setField(Class<?> clazz, Object obj, String field, Object value)	//TODO test
	{
		try
		{
			Field f = clazz.getDeclaredField(field);
			f.setAccessible(true);
			f.set(obj, value);
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
}
