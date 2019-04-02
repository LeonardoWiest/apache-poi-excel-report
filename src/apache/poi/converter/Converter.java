package apache.poi.converter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {

	public static Field[] getAllFields(Class<?> clazz) {

		List<Field> fieldList = new ArrayList<Field>();

		Class<?> superClazz = clazz.getSuperclass();

		if (!superClazz.equals(Object.class)) {
			fieldList.addAll(Arrays.asList(getAllFields(superClazz)));
		}

		fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));

		return fieldList.toArray(new Field[fieldList.size()]);

	}

}
