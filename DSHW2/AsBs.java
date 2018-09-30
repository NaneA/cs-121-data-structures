public class AsBs {
	public static String AsBsDeconstruct(String str) throws IllegalArgumentException {
		String temp = "";


		for(int i = 0; i < str.length()-1; i++) {
			if("AB".equals("" + str.charAt(i) + str.charAt(i+1))) {
				temp+="A";
				i++;
			} else if(i < str.length()-2 && "BBA".equals("" + str.charAt(i) + str.charAt(i+1) + str.charAt(i+2))){
				temp+="B";
				i+=2;
			} else {
				throw new IllegalArgumentException();
			}
		}
		System.out.println(str);
		if(temp.equals(str)) {
			return "";
		}
		return AsBsDeconstruct(temp);
	}

	public static void main(String[] args) {
			System.out.println(AsBsDeconstruct("ABABABABAB"));
	}
}