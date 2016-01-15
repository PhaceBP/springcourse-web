package hu.ericsson.springcourse.dynamic

import hu.ericsson.springcourse.dynamic.Calculator

class GroovyCalculator implements Calculator {


	int add(int a, int b){
		return a + b + 5
	}

}