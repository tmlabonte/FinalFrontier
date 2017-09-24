package frontier.module;

import java.util.ArrayList;

//Class to generate master list of modules during initialization
public class ModuleGenerator {
	public ModuleGenerator() {
	}
	
	//Returns an ArrayList of modules
	public ArrayList<Module> generateModules(int amount) {
		ArrayList<Module> list = new ArrayList<Module>(amount);
		
		//Creates a new Module and adds it to the list
		for (int i=0; i<amount; i++) {
			Module newModule = new Module(Module.randomType());
			list.add(newModule);
		}
		return list;
	}
}