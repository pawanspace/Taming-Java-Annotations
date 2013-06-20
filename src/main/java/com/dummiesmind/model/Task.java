package com.dummiesmind.model;

import com.dummiesmind.annotations.XMLObject;
import com.dummiesmind.annotations.XMLTag;

/*
 *
 *
 * This is a sample class that needs to me
 * converted to XML. Annotation is not a java
 * declarations so it does not end with semicolon.
 *
 *
 *@author Pawan Chopra
 */
@XMLObject("Task")
public class Task {
   @XMLTag("name") private String taskName = "Read about Design Patterns.";
}
