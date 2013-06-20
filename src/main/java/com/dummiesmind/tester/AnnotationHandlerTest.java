package com.dummiesmind.tester;

import java.io.PrintWriter;

import com.dummiesmind.model.Task;
import com.dummiesmind.processor.AnnotationHandler;

public class AnnotationHandlerTest {
 public static void main(String[] args){
    Task task = new Task();
    AnnotationHandler annotationHandler = new AnnotationHandler
    ( new PrintWriter( System.out ) );
    annotationHandler.provideOutput(task);
  }
}