package ma.wiebatouta.models;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.wiebatouta.validation.ExtensionImage;

@Entity
@Table(name = "themes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theme implements Serializable, Comparable<Theme> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "label", nullable = false, length = 60)
	@NotNull(message = "Le label d'un theme ne doit pas être vide")
	@Length(min = 5, max = 60, message = "Le label doit être entre 5 et 60")
	private String label;

	@Column
	@NotNull(message = "Un theme a besoin d'une description")
	@Length(min = 5, max = 60, message = "La description est obligatoire")
	private String description;
	
	@Transient
	private String encodedPicture;
	
	@Lob
	@NotNull(message = "Veuillez inserer une image")
	private byte[] picture;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE })
	@JsonIgnore
	private List<Voyage> voyages = new ArrayList<Voyage>();
	
	@ExtensionImage
	private String fileName;
	
	@Override
	public int compareTo(Theme o) {
		return label.compareTo(o.getLabel());
	}

	public Theme(Long id,
			@NotNull(message = "Le label d'un theme ne doit pas être vide") @Length(min = 5, max = 60, message = "Le label doit être entre 5 et 60") String label,
			@NotNull(message = "Veuillez inserer une image") byte[] picture) {
		super();
		this.id = id;
		this.label = label;
		this.picture = picture;
	}

	public Theme(
			@NotNull(message = "Le label d'un theme ne doit pas être vide") @Length(min = 5, max = 60, message = "Le label doit être entre 5 et 60") String label,
			@NotNull(message = "Un theme a besoin d'une description") @Length(min = 5, max = 60, message = "La description est obligatoire") String description,
			@NotNull(message = "Veuillez inserer une image") byte[] picture) {
		super();
		this.label = label;
		this.description = description;
		this.picture = picture;
	}

	public void encodeAll() throws UnsupportedEncodingException {
		if (getPicture() != null) {
			byte[] encodedphotobyte = Base64.encodeBase64(picture);
			String base64Encoded = new String(encodedphotobyte, "UTF-8");
			setEncodedPhoto(base64Encoded);
		}
	}

	private void setEncodedPhoto(String encodedPicture) {
		this.encodedPicture=encodedPicture;
	}
	
	public String getEncodedString() {
		return encodedPicture;
	}
	
	public void setImagePart(MultipartFile file) throws IOException {
		fileName = file.getOriginalFilename();
		byte image[] = file.getBytes();
		if (image != null && image.length != 0) {
			this.picture = image;
		} else {
			this.picture = null;
		}
	}
}
