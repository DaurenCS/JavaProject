package userPackage;

import java.io.Serializable;

public class Mark implements Serializable {

	private static final long serialVersionUID = 1L;
	private double firstAttestation;
	private double secondAttestation;
	private double finalAttestation;
	private int totalAttestation;
	private MarkLetters mark;
	private double gpa;

	public Mark() {

	}

	public double getFirstAttestation() {
		return this.firstAttestation;
	}

	public void setFirstAttestation(double firstAttestation) {
		this.firstAttestation = firstAttestation;
	}

	public double getSecondAttestation() {
		return this.secondAttestation;
	}

	public void setSecondAttestation(double secondAttestation) {
		this.secondAttestation = secondAttestation;
	}

	public double getFinalAttestation() {
		return this.finalAttestation;
	}

	public void setFinalAttestation(double finalAttestation) {
		this.finalAttestation = finalAttestation;
	}
	/**
	 * count local gpa from attestation
	 * 
	 */
	public double getGpa() {  
        if(this.getTotalAttestation() >= 95) this.gpa = 4.0;   
        else if(this.getTotalAttestation() >= 90 && this.getTotalAttestation() <95)  
         this.gpa = 3.67;  
        else if(this.getTotalAttestation() >= 85 && this.getTotalAttestation() <90)  
         this.gpa = 3.33;  
        else if(this.getTotalAttestation() >= 80 && this.getTotalAttestation() <85)  
         this.gpa = 3.0;  
        else if(this.getTotalAttestation() >= 75 && this.getTotalAttestation() <80)  
         this.gpa = 2.67;  
        else if(this.getTotalAttestation() >= 70 && this.getTotalAttestation() <75)  
         this.gpa = 2.33;  
        else if(this.getTotalAttestation() >= 65 && this.getTotalAttestation() <70)  
         this.gpa = 2.0;  
        else if(this.getTotalAttestation() >= 60 && this.getTotalAttestation() <65)  
         this.gpa = 1.67;  
        else if(this.getTotalAttestation() >= 55 && this.getTotalAttestation() <60)  
         this.gpa = 1.33;  
        else if(this.getTotalAttestation() >= 50 && this.getTotalAttestation() <55)  
         this.gpa = 1.0;  
        else   
         this.gpa = 0.0;  
          
        return this.gpa; 
          
       }  


	/**
	 *sets gpa
	 * 
	 * @param gpa
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;

	}

	public int getTotalAttestation() {
		this.setTotalAttestation((this.firstAttestation + this.secondAttestation + this.finalAttestation));
		return this.totalAttestation;

	}

	public void setTotalAttestation(double totalAttestation) {
		this.totalAttestation = (int) totalAttestation;
	}

	public MarkLetters getMark() {
		return this.mark;
	}

	public void setMark(MarkLetters mark) {
		this.mark = mark;
	}

	public String toString() {
		return this.firstAttestation + " | " + this.secondAttestation + " | " + this.finalAttestation + " || "
				+ this.totalAttestation + " | " + this.mark;
	}

}