package crackingTheCodingInterview.chapter8;

import java.util.ArrayList;
import java.util.LinkedList;

public class CallCenter {

	private ArrayList<Respondent> employees;
	private LinkedList<Call> waiting_calls;
	
	private static CallCenter _instance = null;
	
	private CallCenter() { }
	public static CallCenter getCallCenterInstance() {
		if (_instance == null)  {
			_instance = new CallCenter();
		}
		return _instance;
	}
	
	// Receive a call, and look for the free answer
	public boolean dispatchCall(Call call) {
		Employee emp = null;
		for (Respondent e : employees) {
			if (!e.isBusy()) {
				emp = e;
				emp.assignCall(call);
				break;
			}
		}
		
		// all employees are busy, return false, tell caller to wait
		if (emp == null) enqueueCall(call);
		return emp != null;
	}
	
	private void enqueueCall(Call call) {
		// ...
	}
	
	// called when an employee is free
	public Call getAWaitingCall() {
		return waiting_calls.remove();
	}
}


abstract class Employee {

	protected String name;
	protected int level;
	
	protected Call current_call;
	
	public Employee (String name, int level) {
		this.name = name;
		this.level = level;
	}
	
	protected boolean isBusy() {
		return current_call != null;
	}
		
	protected void finishCall() {
		current_call = null;
	}
	
	protected boolean assignCall(Call call) {
		if (!isBusy()) {
			current_call = call;
			return true;
		}
		return escalateCall();
	}
	
	protected abstract boolean escalateCall();
}

class Respondent extends Employee {
	
	Manager manager;
	
	public Respondent(String name) {
		super(name, 1);
	}

	@Override
	protected boolean escalateCall() {
		if (!manager.isBusy()) {
			boolean r = manager.assignCall(current_call);
			if (r) {
				finishCall();
			}
			return r;
		}
		return false;
	}
}

class Manager extends Employee {
	
	Director director;
	ArrayList<Respondent> respondents;
	
	public Manager(String name) {
		super(name, 2);
	}

	@Override
	protected boolean escalateCall() {
		if (!director.isBusy()) {
			boolean r = director.assignCall(current_call);
			if (r) {
				finishCall();
			}
			return r;
		}
		return false;
	}
}

class Director extends Employee {
	
	ArrayList<Manager> managers;
	
	public Director(String name) {
		super(name, 3);
	}

	@Override
	protected boolean escalateCall() {
		return false;
	}
}

class Call {
	
	String from;
	Employee call_handler;
	
	public Call() {
		
	}
}