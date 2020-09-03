package it.polito.tdp.PremierLeague.model;

public class Vicino  implements Comparable<Vicino>{

	private Team t1;
	private Integer differenzaPunti;
	public Vicino(Team t1, Integer differenzaPunti) {
		super();
		this.t1 = t1;
		this.differenzaPunti = differenzaPunti;
	}
	public Team getT1() {
		return t1;
	}
	public void setT1(Team t1) {
		this.t1 = t1;
	}
	public Integer getDifferenzaPunti() {
		return differenzaPunti;
	}
	public void setDifferenzaPunti(Integer differenzaPunti) {
		this.differenzaPunti = differenzaPunti;
	}
	@Override
	public String toString() {
		return  t1 + " ("+ this.differenzaPunti+" ) ";
	}
	@Override
	public int compareTo(Vicino o) {
		// TODO Auto-generated method stub
		return (this.differenzaPunti.compareTo(o.getDifferenzaPunti()));
	}
	
	
	
	
	
	
}
