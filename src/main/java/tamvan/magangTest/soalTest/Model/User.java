package tamvan.magangTest.soalTest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table (name="user")
public class User { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	private Integer id;	
	
	
	@NotEmpty(message = "Nama tidak boleh kosong")
	@Size(max=50, message = "Minimal 50 karakter")
	@Column (name = "nama")
	private String  nama;
	
	@Size(min=10, message = "Minimal 10 karakter")
	@Pattern(regexp="^(0|[0-9]*)$", message = "Masukan harus angka")
	private String nohp;
	
	@NotEmpty(message = "Email tidak boleh kosong")
    @Email(message = "Format email salah")
	@Column (name = "email")
	private String email;

	@NotEmpty(message = "Alamat tidak boleh kosong")
	@Column (name = "alamat")
	private String alamat;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNohp() {
		return nohp;
	}

	public void setNohp(String nohp) {
		this.nohp = nohp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}	
}

