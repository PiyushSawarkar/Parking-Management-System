
public class ToStartWith {
	public static void main(String args[]) {
		LoadingScreen ls = new LoadingScreen();
		ls.setVisible(true);
		ls.setLocationRelativeTo(null);
		try {
			int i;
			for(i=0;i<=100;i++) {
				Thread.sleep(70);
				if(i<=20)
					ls.lblTextBox.setText("Hi");
				else if(i>20&&i<=40) {
					ls.lblTextBox.setText("Getting Things Ready For You...");
				}
				else if(i>40&&i<=60) {
					ls.lblTextBox.setText("plz...wait a sec");
				}
				else if(i>60&&i<=80) {
					ls.lblTextBox.setText("We're almost Done...");
				}
				else {
					Thread.sleep(300);
					ls.lblTextBox.setText("Welcome");
				}
				
				//ls.lblPercentage.setText(Integer.toString(i)+"%");
				//ls.progressBar.setValue(i);
				
			}
			
			//Thread.sleep(1000);
			ls.dispose();
			/*BeforeDriverOnwardConrtroller bd = new BeforeDriverOnwardConrtroller();
			
			//bd.setVisible(true);
			//bd.setLocationRelativeTo(null);
			bd.start();*/
			
			
			//Thread.sleep(450);
			BeforeDriver b =new BeforeDriver();
			b.setVisible(true);
			b.setLocationRelativeTo(null);
			try {
				i=0;
				for(i=0;i<=120;i++) {
					Thread.sleep(70);
					if(i<=20)
						b.lblIntroducing.setVisible(true);
					else if(i>20&&i<=40) {
						b.lblTheConceptOf.setVisible(true);
					}
					else if(i>40&&i<=60) {
						b.lblParking.setVisible(true);
					}
					else if(i>60&&i<=80) {
						b.lblManagement.setVisible(true);
					}
					else if(i>80&&i<=100){
						//Thread.sleep(300);
						b.lblSystem.setVisible(true);
					}
					else {
						b.label_1.setVisible(true);
						
					}
					
					//ls.lblPercentage.setText(Integer.toString(i)+"%");
					//ls.progressBar.setValue(i);
					
				}
				
				Thread.sleep(2000);
				b.dispose();
				Driver d = new Driver();
				d.setVisible(true);
				d.setLocationRelativeTo(null);
				
				
				
			}catch(Exception e) {
				e.getMessage();
			}
			
			
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
