package myspittr.validates;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import myspittr.spitter.Spitter;

public class SpitterRegisterValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub

		Spitter spitter = (Spitter) arg0;

		String username = spitter.getUsername();
		if (username.length() < 6 || username.length() > 12) {
			errors.rejectValue("username", "spittr.username");
		} else {
			char firString = username.toCharArray()[0];
			if (!(firString >= 'A' && firString <= 'Z' || firString <= 'z' && firString >= 'a')) {
				errors.rejectValue("username", "spittr.username");
			}
		}

		String password1 = spitter.getPassword();
		String password2 = spitter.getPasswordconfirm();
		if (!password1.equals(password2)) {

			errors.rejectValue("passwordconfirm", "spittr.passwordconfirm");
		} else {
			if (password1.length() < 6 || password1.length() > 16) {
				errors.rejectValue("password", "spittr.password");
			}
		}

		String email = spitter.getEmail();
		String string = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$ ";
		if (!email.matches(string)) {
			errors.rejectValue("email", "spittr.email");
		}
		// if (!(email.contains("@") && email.contains("."))) {
		// errors.rejectValue("email", "spittr.email");
		// }else {
		// String[] str1=email.split("@");
		// if(){}
		// }

	}

}
