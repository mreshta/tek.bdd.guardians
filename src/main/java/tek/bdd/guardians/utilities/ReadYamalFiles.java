package tek.bdd.guardians.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;


import org.yaml.snakeyaml.Yaml;

public class ReadYamalFiles {

	private static ReadYamalFiles readYamalFiles;
	private HashMap propertyType;
	
	private ReadYamalFiles(String filePath)throws FileNotFoundException{
	FileInputStream fileInputStream=FileUtility.getFileInputStream(filePath);
	Yaml yaml=new Yaml();
	this.propertyType=yaml.load(fileInputStream);
	}
	
	public static ReadYamalFiles getInstance(String filePath)throws FileNotFoundException {
		if(readYamalFiles==null) 
			return new ReadYamalFiles(filePath);
			return readYamalFiles;
		
	}
	
	public HashMap getYamalProperty(String key) {
		
		return (HashMap)this.propertyType.get(key);
		
	}
	
	
	
	
	
	
	
}



