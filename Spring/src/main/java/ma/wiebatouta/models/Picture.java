package ma.wiebatouta.models;

import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;
import ma.wiebatouta.validation.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.wiebatouta.models.enums.TypePicture;

@Entity
@Table(name = "pictures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture implements Serializable, Comparable<Picture> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TypePicture type;
	
	private String fileName;
	
	@Lob
	@NotNull(message = "On a besoin d'au moins d'une image")
	@JsonIgnore
	private byte[] picture;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JsonIgnore
	private Voyage voyage;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JsonIgnore
	private Hotel hotel;

	public Picture(byte[] picture, Voyage voyage) {
		super();
		this.picture = picture;
		this.voyage = voyage;
	}
	
	public void setPicturePart(MultipartFile file) throws IOException {
		fileName = file.getOriginalFilename();
		byte image[] = file.getBytes();
		if(image != null && image.length != 0) {
			this.picture = image;
		}else {
			this.picture = null;
		}
	}
	
	@Override
	public int compareTo(Picture o) {
		if (id < o.getId()) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public String getBase64() {
		String c = "";
		if(this.picture != null && this.picture.length != 0) {
			c = Base64.getEncoder().encodeToString(this.picture);
		}
		return c;
	}

}
