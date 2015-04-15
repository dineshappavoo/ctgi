/**
 * 
 */
package com.ctgi.google.languages.java.code.abstractclass;

/**
 * @author Dany
 *
 */
public class GameUser {

	public static void main(String[] args) {
		new GameUser().requestGame();
	}
	
	public void requestGame()
	{
		AssasinGame asGame = new AssasinGame();
		NFSGame nfsGame = new NFSGame();
		asGame.displaygridID();
		nfsGame.displaygridID();
		
		AssasinGame asGame1 = new AssasinGame("grid_14","vm_img_gpu13");
		NFSGame nfsGame1 = new NFSGame("grid_15","vm_img_gpu15");
		asGame1.displaygridID();
		nfsGame1.displaygridID();
		
	}
}
