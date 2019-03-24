package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class dataReader {

	public String AddReceipeName;
	public String AddIngredients;
	public String EditReceipeName;
	public String EditIngredients;

	public void readData() throws FileNotFoundException, IOException, ParseException{

		String filepath=System.getProperty("user.dir")+"/src/main/java/data/jsondata.json";
		File srcfile=new File(filepath);
		JSONParser parser=new JSONParser();
		JSONArray jsonArray=(JSONArray) parser.parse(new FileReader(srcfile));

		for (Object jarray:jsonArray) {

			JSONObject taskData = (JSONObject) jarray;
			AddReceipeName = (String) taskData.get("add_receipe_name");
			AddIngredients = (String) taskData.get("add_ingredients");
			EditReceipeName = (String) taskData.get("edit_receipe_name");
			EditIngredients = (String) taskData.get("edit_ingredients");
		}

	}
}
