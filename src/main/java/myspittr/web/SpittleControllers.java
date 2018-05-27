package myspittr.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import myspittr.data.GenerateUnID;
import myspittr.data.SpittleRepositorys;
import myspittr.pubspittle.PubSpittle;
import myspittr.spittle.Spittle;

@Controller
public class SpittleControllers {

	private SpittleRepositorys spittleRepository;
	private String username;
	private String url;

	@Autowired
	public SpittleControllers(SpittleRepositorys spittleRepository) { //
		this.spittleRepository = spittleRepository;
	}

	@RequestMapping(value = "/spittles", method = RequestMethod.GET)
	public List<Spittle> spittles(HttpServletRequest request, @RequestParam(value = "username") String username,
			Model model) {
		this.url = request.getServletContext().getRealPath("/image");
		System.out.println(url);
		this.username = username;
		if (username != "") {
			this.username = username;
			model.addAttribute(new PubSpittle());
			return spittleRepository.findSpittles();
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/spittles/spittle", method = RequestMethod.GET)
	public String singleSpittle(@RequestParam(value = "id") Long id, Model model) {
		model.addAttribute("spittle", spittleRepository.findOne(id));
		return "spittle";
	}

	@RequestMapping(value = "/spittles2", method = RequestMethod.GET)
	public List<Spittle> spittles2() {
		return spittleRepository.findSpittles();
	}

	@RequestMapping(value = "/spittles", method = RequestMethod.POST)
	public String addSpittle(HttpServletRequest request, PubSpittle pubSpittle)
			throws IllegalStateException, IOException {

		MultipartFile profilePicture = pubSpittle.getSpittlePicture();
		String id = Long.toString(GenerateUnID.next());
		if (profilePicture.getSize() != 0) {
			profilePicture.transferTo(new File(url, id + ".jpg"));
			pubSpittle.setSpittlePictureString(id);
		} else {
			pubSpittle.setSpittlePictureString("spitter_logo_50");
		}
		spittleRepository.save(pubSpittle);
		return "redirect:/spittles?username=" + username;
	}

}
