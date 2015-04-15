/**
 * 
 */
package com.ctgi.google.languages.java.code.abstractclass;

/**
 * @author Dany
 *
 */
public class NFSGame extends GridVM{

	public NFSGame() {	
		super();
		this.gridId = "grid_12";
		this.vmName = "vm_assasin";
	}
	public NFSGame(String gridId, String vmName) {
		super();
		this.gridId = gridId;
		this.vmName = vmName;
	}

	@Override
	public void displaygridID() {
		System.out.println("Grid Id : "+gridId+"  VM Name : "+vmName);
	}
}
