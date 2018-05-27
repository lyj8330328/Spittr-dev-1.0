package myspittr.pubspittle;

import org.springframework.web.multipart.MultipartFile;

public class PubSpittle {
	private String message;
	private String title;
	private String username;
	private MultipartFile spittlePicture;
	private String spittlePictureString;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MultipartFile getSpittlePicture() {
		return spittlePicture;
	}

	public void setSpittlePicture(MultipartFile spittlePicture) {
		this.spittlePicture = spittlePicture;
	}

	public String getSpittlePictureString() {
		return spittlePictureString;
	}

	public void setSpittlePictureString(String spittlePictureString) {
		this.spittlePictureString = spittlePictureString;
	}
}
