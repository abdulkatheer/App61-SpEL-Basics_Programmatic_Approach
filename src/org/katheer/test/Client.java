package org.katheer.test;

import org.katheer.bean.Student;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Client {
    public static void main(String[] args) {
        /*
        SpEL - A programming language to easily manipulate object and its
        properties at runtime.

        It can be used in Java program, spring configuration file and
        annotations.

        In programmatic approach, we've create an parser. Using that parser
        we can create expressions using parseExpression method.

        We can evaluate that expression using getValue() method.
         */

        //Evaluating SpEL expression
        //1. Create a parser
        ExpressionParser parser = new SpelExpressionParser();
        //2. Create Expression
        Expression exp1 = parser.parseExpression("10 + 10");
        //3. Evaluate Expression
        System.out.println(exp1.getValue());

        //Setting values to objects via SpEL
        //1. Create a EvaluationContext, it's a container that enables SpEL
        // to manipulate that object at runtime
        Student student = new Student();
        //Create a context for object - it stores, manipulates data for that
        // object at runtime
        StandardEvaluationContext context = new StandardEvaluationContext(student);

        //Setting values for bean properties
        Expression exp2 = parser.parseExpression("name");
        exp2.setValue(context, "Katheer");
        Expression exp3 = parser.parseExpression("addr");
        exp3.setValue(context,"Bangalore");

        System.out.println("Name    : " + student.getName());
        System.out.println("Address : " + student.getAddr());
    }
}
