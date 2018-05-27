package myspittr.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import myspittr.data.SpitterRepositorys;
import myspittr.spitter.Spitter;
import myspittr.validates.SpitterRegisterValidator;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRepositorys spitterRepository;

	@Autowired
	public SpitterController(SpitterRepositorys spitterRepository) {
		this.spitterRepository = spitterRepository;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET) //
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Spitter());
		return "registerForm3";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(HttpServletRequest request, @Validated Spitter spitter, BindingResult errors)
			throws IllegalStateException, IOException {

		MultipartFile profilePicture = spitter.getProfilePicture();
		profilePicture.transferTo(
				new File(request.getServletContext().getRealPath("/image"), spitter.getUsername() + ".jpg"));

		SpitterRegisterValidator spitterValidator = new SpitterRegisterValidator();
		spitterValidator.validate(spitter, errors);
		if (errors.hasErrors()) {
			return "registerForm3";
		} else {
			spitterRepository.save(spitter); //
			return "redirect:/spitter/" + spitter.getUsername(); //

		}

	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
}
