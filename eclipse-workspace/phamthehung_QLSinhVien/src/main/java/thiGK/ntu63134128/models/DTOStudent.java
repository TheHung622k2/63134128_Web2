package thiGK.ntu63134128.models;

public class DTOStudent {
	private String maSV;
	private String tenSV;
	private String diemTichLuy;
	
	public DTOStudent(String maSV, String tenSV, String diemTichLuy) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.diemTichLuy = diemTichLuy;
	}

	public DTOStudent() {
		super();
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(String diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}	
}
