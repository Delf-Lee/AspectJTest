package concern;

import control.Control;

public aspect AspectForLogging {
	pointcut callaccess() : call (* service.ClientService.login(String, String));

	pointcut idcheck() : call (* service.ClientService.isIdExist(String));

	pointcut passwordcheck() : call (* service.ClientService.isPasswordCorrect(..));

	/* logging when client try to access */
	before() :callaccess() {
		String now = "[" + Control.now() + "]";
		System.out.println(now + " \"" + Control.getId() + "\"" + " is try access.");
	}

	/* logging: user id exist in database or not */
	after() returning(boolean result) : idcheck() {
		if (result) {
			System.out.println("	id exist...");
		}
		else {
			System.out.println("	id not exist...");
		}
	}

	/* logging: password correct or not */
	after() returning(boolean result) : passwordcheck() {
		if (result) {
			System.out.println("	password correct...");
		}
		else {
			System.out.println("	password not correct...");
		}
	}
	/* logging: is login success or not */
	after() returning(boolean result) : callaccess() {
		if (result) {
			System.out.println("	login success!\n");
		}
		else {
			System.out.println("	login false!\n");
		}
	}
}
