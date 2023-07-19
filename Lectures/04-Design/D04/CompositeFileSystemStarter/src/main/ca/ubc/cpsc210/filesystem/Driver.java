package ca.ubc.cpsc210.filesystem;


public class Driver {

	public static void main(String args[]) {
        Folder fA, fB, fC, fD;

        fA = new Folder("dirA");
        fA.addChild(new File("fileInA"));
        fB = new Folder("dirB-in-dirA");
        fB.addChild(new File("fileInB1"));
        fB.addChild(new File("fileInB2"));
        fA.addChild(fB);
        fC = new Folder("dirC-in-dirA");
        fA.addChild(fC);
        fC.addChild(new File("fileInC"));
        fD = new Folder("dirD-in-dirC");
        fC.addChild(fD);
        fC.addChild(new File("componentInC"));    // Added: file has same name as a folder in "dirC-in-dirA"
        fC.addChild(new Folder("componentInC"));  // Added: folder has same name as a file in "dirC-in-dirA"
        fC.addChild(new File("fileInC"));         // Not added: "dirC-in-dirA" already has file named "fileInC"
        fC.addChild(new Folder("dirD-in-dirC"));  // Not added: "dirC-in-dirA" already has folder named "dirD-in-dirC"

        FileSystemResource r = fA;
        r.print();

        System.out.println();
        r = fB;
        r.print();
	}
}
