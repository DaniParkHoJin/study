package model;

import java.util.Date;

public class TraineeVO {
	// �ʵ� ����
	private int no;	// ���� �Ϸù�ȣ
	private String sd_num; // �й�
	private String l_abbre; // ���� ���
	private String t_section; // ���� ����
	private String t_date; // �����
	// ������
	public TraineeVO() {
		super();
	}
	// ��� �ʵ带 ������
	public TraineeVO(int no, String sd_num, String l_abbre, String t_section, String t_date) {
		super();
		this.no = no;
		this.sd_num = sd_num;
		this.l_abbre = l_abbre;
		this.t_section = t_section;
		this.t_date = t_date;
	}
	// ������
	public int getNo() {
		return no;
	}
	public String getSd_num() {
		return sd_num;
	}
	public String getL_abbre() {
		return l_abbre;
	}
	public String getT_section() {
		return t_section;
	}
	public String getT_date() {
		return t_date;
	}
	// ������
	public void setNo(int no) {
		this.no = no;
	}
	public void setSd_num(String sd_num) {
		this.sd_num = sd_num;
	}
	public void setL_abbre(String l_abbre) {
		this.l_abbre = l_abbre;
	}
	public void setT_section(String t_section) {
		this.t_section = t_section;
	}
	public void setT_date(String t_date) {
		this.t_date = t_date;
	}
	
	@Override
	public String toString() {
		return "traineeVo [no=" + no + ", sd_num=" + sd_num + ", l_abbre=" + l_abbre + ", t_section=" + t_section
				+ ", t_date=" + t_date + "]";
	}
	
	
	
}