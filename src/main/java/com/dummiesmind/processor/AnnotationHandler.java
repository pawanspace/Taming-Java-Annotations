package com.dummiesmind.processor;
import java.io.PrintWriter;
import java.lang.reflect.Field;

import com.dummiesmind.annotations.XMLObject;
import com.dummiesmind.annotations.XMLTag;

/*
 *
 *
 * This class is the heart of annotations. This is
 * the class which makes annotations valuable in Java.
 * I have written this for annotations. I have defined
 * in case you want to create your own Annotations you
 * need to have a handler like this which can compile
 * your annotaions in a useful way that too at run time
 * (Remember we have a retention policy of Runtime?). This
 * class has a heavy use of reflection which is used to
 * do alot of operations at run time. In case you are not
 * familiar with Reflection api of Java
 * This class basically use {@link Class#getAnnotation(Class)}
 * method of {@link Class}. This gives you access to the
 * annotation object at run time then you can class defined
 * methods on that object and fetch the values.
 * This class has mainly two methods one for handling
 * object level annotations and other for handling field
 * level annotations. You can extend this class for your own
 * purpose for example for handling diffrent type of fields
 * and also methods.
 *
 *
 *@author Pawan Chopra
 */
public class AnnotationHandler {
	private PrintWriter out;

	public AnnotationHandler(PrintWriter out) {
		this.out = out;
	}

	/*
	 * 
	 * This method handles the object level annotations.
	 * 
	 * @param object
	 */
	private void handleObjectLevelAnnotation(Object object) {
		XMLObject xmlObjectAnnotation = (XMLObject) object.getClass().getAnnotation(XMLObject.class);
		if (xmlObjectAnnotation == null) {
			out.print("Nothing to be flushed.");
		} else {
			String[] className = xmlObjectAnnotation.value();
			if (className.length > 0) {
				out.println("<" + className[0] + ">");
				handleFieldLevelAnnotation(object);
				out.println("</" + className[0] + ">");
				out.flush();
			}
		}
	}

	/*
	 * 
	 * This methods handles the field level annotations.
	 * 
	 * @param object
	 */
	private void handleFieldLevelAnnotation(Object object) {
		Field[] fields = object.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true); // Make private fields accessible.
			XMLTag xmlTag = (XMLTag) fields[i].getAnnotation(XMLTag.class);
			if (xmlTag == null) {
				continue;
			} else {
				String[] fieldName = xmlTag.value();
				if (fieldName.length > 0) {
					out.print("\t<" + fieldName[0] + ">");
					try {
						/*
						 * I have only one field in Task class you can have
						 * multiple so in that case check for the field type and
						 * use if else or switch case to handle multiple fields.
						 */
						out.print(((String) fields[0].get(object)));
					} catch (IllegalArgumentException e) {
						/*
						 * TODO Do something really better here or wait for my
						 * next Article!
						 */
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						/*
						 * TODO Do something really better here or wait for my
						 * next Article!
						 */
						e.printStackTrace();
					}
					out.println("</" + fieldName[0] + ">");
				}
			}
		}
	}

	/*
	 * 
	 * This is just a start up method which is exposed to the client for
	 * starting the conversion.
	 * 
	 * @param object
	 */
	public void provideOutput(Object object) {
		handleObjectLevelAnnotation(object);
	}
}