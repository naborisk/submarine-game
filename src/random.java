import java.util.Random;

public class random {
	
	private int secondj;
	private int thirdi;
	private int fourthj;
	
	public random(){}
	
	public random(int secondj, int thirdi, int fourthj){
		this.secondj = secondj;
		this.thirdi = thirdi;
		this.fourthj = fourthj;
	}
	
	public int getsecondj() {return secondj;}
	public int getthirdi() {return thirdi;}
	public int getfourthj() {return fourthj;}
	
	public void setsecondj(int secondj) {this.secondj = secondj;}
	public void setthirdi(int thirdi) {this.thirdi = thirdi;}
	public void setfourthj(int fourthj) {this.fourthj = fourthj;}
	
	public void randomSecond(int firsti, int firstj, int secondi){
		Random ran = new Random();
		int secondj;
		if(firstj == 1){
			if(firsti == 1){
				if(secondi == 1){
					secondj = ran.nextInt(2)+4;
				}else{
					secondj = ran.nextInt(2)+3;
				}
			}else{
				if(secondi == 1){
					secondj = ran.nextInt(2)+3;
				}else{
					secondj = ran.nextInt(2)+4;
				}
			}
		}else{
			if(firsti == 1){
				if(secondi == 1){
					secondj = 5;
				}else{
					secondj = ran.nextInt(2)+4;
				}
			}else{
				if(secondi == 1){
					secondj = ran.nextInt(2)+4;
				}else{
					secondj = 5;
				}
			}
		}
		setsecondj(secondj);
	}
	
	public void randomThird(int secondi, int secondj, int thirdj){
		Random ran = new Random();
		int thirdi;
		
		if(secondi == 1){
			if(secondj == 3){
				if(thirdj == 3){
					thirdi = ran.nextInt(2)+4;
				}else{
					thirdi = ran.nextInt(3)+3;
				}
			}else if(secondj == 4){
				if(thirdj == 4){
					thirdi = ran.nextInt(2)+4;
				}else{
					thirdi = ran.nextInt(3)+3;
				}
			}else{
				if(thirdj == 5){
					thirdi = ran.nextInt(2)+4;
				}else{
					thirdi = ran.nextInt(3)+3;
				}
			}
		}else{
			if(secondj == 3){
				if(thirdj == 3){
					thirdi = 5;
				}else if(thirdj == 4){
					thirdi = ran.nextInt(2)+4;
				}else{
					thirdi = ran.nextInt(3)+3;
				}
			}else if(secondj == 4){
				if(thirdj == 4){
					thirdi = 5;
				}else{
					thirdi = ran.nextInt(2)+4;
				}
			}else{
				if(thirdj == 5){
					thirdi = 5;
				}else if(thirdj == 4){
					thirdi = ran.nextInt(2)+4;
				}else{
					thirdi = ran.nextInt(3)+3;
				}
			}
		}
		setthirdi(thirdi);
	}
	
	public void randomFourth(int thirdi, int thirdj, int fourthi){
		Random ran = new Random();
		int fourthj = 0;
		
		if(thirdj == 3){
			if(thirdi == 3){
				if(fourthi == 4){
					fourthj = 1;
				}else if(fourthi == 5){
					fourthj = ran.nextInt(2)+1;
				}
			}else if(thirdi == 4){
				if(fourthi == 3){
					fourthj = 1;
				}else if(fourthi == 5){
					fourthj = 1;
				}
			}else{
				if(fourthi == 3){
					fourthj = ran.nextInt(2)+1;
				}else if(fourthi == 4){
					fourthj = 1;
				}
			}
		}else if(thirdj == 4){
			if(thirdi == 3){
				if(fourthi == 3){
					fourthj = 1;
				}else{
					fourthj = ran.nextInt(2)+1;
				}
			}else if(thirdi == 4){
				if(fourthi == 4){
					fourthj = 1;
				}else{
					fourthj = ran.nextInt(2)+1;
				}
			}else{
				if(fourthi == 5){
					fourthj = 1;
				}else{
					fourthj = ran.nextInt(2)+1;
				}
			}
		}else{
			fourthj = ran.nextInt(2)+1;
		}
		setfourthj(fourthj);
	}
}
