package com.epam.rd.autotasks.arithmeticexpressions;

//import java.util.StringJoiner;

public class Expressions {	

	public static Variable var(String name, int value) {
        //implement this method
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        Expression expression = new Expression() {
			
			@Override
			public String toExpressionString() {
				String str = String.valueOf(value);
				if(value < 0) str = "("+str+")";
				return str;
			}
			
			@Override
			public int evaluate() {
				// TODO Auto-generated method stub
				return value;
			}
		};
        return expression;
    }

    public static Expression sum(Expression... members){
        Expression expression = new Expression() {
			
			@Override
			public String toExpressionString() {
				String str = "("+members[0].toExpressionString();
				for (int i = 1; i < members.length; i++) {
					str+=" + "+members[i].toExpressionString();
				}
				return str+")";
			}
			
			@Override
			public int evaluate() {
				int sum = 0;
				for (Expression expression : members) {
					sum+=expression.evaluate();
				}
				return sum;
			}
		};
        return expression;
    }

    public static Expression product(Expression... members){
        Expression expression = new Expression() {
			
			@Override
			public String toExpressionString() {
				String str = "("+members[0].toExpressionString()+" * "+members[1].toExpressionString();
				for (int i = 2; i < members.length; i++) {
					str+=" * "+members[i].toExpressionString();
				}				
				return str+")";
			}
			
			@Override
			public int evaluate() {
				int mult = members[0].evaluate() * members[1].evaluate();
				for (int i = 2; i < members.length; i++) {
					mult *= members[i].evaluate();									
				}
				return mult;
			}
		};
        return expression;
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        Expression expression = new Expression() {
			
			@Override
			public String toExpressionString() {
				// TODO Auto-generated method stub
				return "("+minuend.toExpressionString()+" - "+subtrahend.toExpressionString()+")";
			}
			
			@Override
			public int evaluate() {				
				return minuend.evaluate()-subtrahend.evaluate();
			}
		};
        return expression;
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        Expression expression = new Expression() {
			
			@Override
			public String toExpressionString() {
				// TODO Auto-generated method stub
				return "("+dividend.toExpressionString()+" / "+divisor.toExpressionString()+")";
			}
			
			@Override
			public int evaluate() {
				// TODO Auto-generated method stub
				return dividend.evaluate() / divisor.evaluate();
			}
		};
        return expression;
    }

	

}
