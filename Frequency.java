import java.util.HashMap;
import java.lang.Character;
import java.util.regex.Pattern;


public class Frequency{
	public static void main(String[] args){
		String str = args[0];
		CountFrequency(str);
	}

	public static void CountFrequency(String str){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0 ; i < str.length() ; i ++ ){
			Character s = str.charAt(i);
			s = Character.toLowerCase(s);
			if(Character.toString(s).matches("[\\s | \\p{Punct}]")){
				continue;
			}
			if(map.containsKey(s)){
				Integer n = map.get(s);
				map.put(s, n+1);
			}else{
				map.put(s, 1);
			}
		}

		for(int i = 0 ; i < str.length() ; i ++ ){
			Character s = str.charAt(i);
			s = Character.toLowerCase(s);
			if(map.containsKey(s)){
				System.out.println(s+": "+map.get(s));
				map.remove(s);
			}
		}
	}
}
