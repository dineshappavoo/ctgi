/**
 * 
 */
package com.ctgi.google.languages.java.code;

/**
 * @author Dany
 *
 */
public class AssasinGame extends GridVM {

	public AssasinGame() {
		super();
		this.gridId = "grid_12";
		this.vmName = "vm_assasin";
	}
	public AssasinGame(String gridId, String vmName) {
		super();
		this.gridId = gridId;
		this.vmName = vmName;
	}

	@Override
	public void displaygridID() {
		System.out.println("Grid Id : "+gridId+"  VM Name : "+vmName);		
	}
}
